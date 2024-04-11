package br.com.talespalma.restorantepanucci.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.talespalma.restorantepanucci.ui.ViewModel.FoodsListVIewModel
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenCardapio


internal const val cardapioRoute = "cardapio"
fun NavGraphBuilder.cardapioListScreen(navController: NavHostController) {
    composable(route = cardapioRoute) {
        val viewModel = viewModel<FoodsListVIewModel>()
        val uiState by viewModel.uiState.collectAsState()
        ScreenCardapio(
            products = uiState.products,
            onClick = {
                navController.navigateToInfo(it.id)
            }
        )
    }
}

fun NavController.navigateToCardapio(navOptions: NavOptions? = null) {
    navigate(cardapioRoute, navOptions = navOptions)
}
