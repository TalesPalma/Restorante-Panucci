package br.com.talespalma.restorantepanucci.ui.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.talespalma.restorantepanucci.dao.ProductDao
import br.com.talespalma.restorantepanucci.ui.uistate.FoodsListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FoodsListVIewModel(
    private val dao: ProductDao = ProductDao()
) : ViewModel() {
    private val _uiState = MutableStateFlow(FoodsListUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            dao.productFoods.collect { products ->
                _uiState.update {
                    it.copy(products = products)
                }
            }
        }
    }

}
