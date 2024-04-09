package br.com.talespalma.restorantepanucci.ui.uistate

import br.com.talespalma.restorantepanucci.model.Product

data class FoodsListUiState(
    val products: List<Product> = emptyList()
)