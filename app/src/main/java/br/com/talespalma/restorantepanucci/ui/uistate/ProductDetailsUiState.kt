package br.com.alura.panucci.ui.uistate

import br.com.talespalma.restorantepanucci.model.Product

sealed class ProductDetailsUiState{
    abstract val product: Product?

    object Loading: ProductDetailsUiState() {
        override val product: Product?
            get() = null
    }

    object Empty: ProductDetailsUiState() {
        override val product: Product?
            get() = null
    }

    object Error: ProductDetailsUiState() {
        override val product: Product?
            get() = null
    }

    class Success(
        override val product: Product? = null
    ): ProductDetailsUiState()

}