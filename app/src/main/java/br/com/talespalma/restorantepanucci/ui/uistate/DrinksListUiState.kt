package br.com.alura.panucci.ui.uistate

import br.com.talespalma.restorantepanucci.model.Product

data class DrinksListUiState(
    val products: List<Product> = emptyList()
)