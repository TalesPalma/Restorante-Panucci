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

    private val _uiState = MutableStateFlow(ProductDetailsUiState())
    val uiState = _uiState.asStateFlow()

    fun findProductById(id: String) {
        dao.findById(id)?.let { product ->
            _uiState.update {
                it.copy(product = product)
            }
        }
    }

}