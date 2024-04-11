package br.com.alura.panucci.ui.viewmodels

import androidx.lifecycle.ViewModel
import br.com.alura.panucci.ui.uistate.ProductDetailsUiState
import br.com.talespalma.restorantepanucci.dao.ProductDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProductDetailsViewModel(
    private val dao: ProductDao = ProductDao()
) : ViewModel() {

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