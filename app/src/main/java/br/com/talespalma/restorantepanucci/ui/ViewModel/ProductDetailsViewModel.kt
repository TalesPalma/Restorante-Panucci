package br.com.alura.panucci.ui.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.panucci.ui.uistate.ProductDetailsUiState
import br.com.talespalma.restorantepanucci.dao.ProductDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


const val SAVE_STATE_KEY = "product-message"

class ProductDetailsViewModel(
    private val dao: ProductDao = ProductDao(),
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {

        viewModelScope.launch {
            val stateFlow =
                savedStateHandle.getStateFlow<String?>(SAVE_STATE_KEY, null).filterNotNull()
                    .collect { id ->
                    findProductById(id)
                    }
        }

    }

    private val _uiState = MutableStateFlow(ProductDetailsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun findProductById(id: String): ProductDetailsUiState? {
        _uiState.update { ProductDetailsUiState.Loading }

        if (id.isBlank()) {
            return ProductDetailsUiState.Empty
        }

        return dao.findById(id)?.let { product ->
            ProductDetailsUiState.Success(product)
        }
    }

}