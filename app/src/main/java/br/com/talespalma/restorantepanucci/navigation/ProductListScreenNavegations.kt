package br.com.talespalma.restorantepanucci.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import br.com.alura.panucci.ui.viewmodels.DrinksListViewModel
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenProduct




internal const val ProductRoute = "product"
private const val uri = "alura://panucci.com.br/drinks"
fun NavGraphBuilder.productListScreen(navController: NavHostController) {
    composable(route = ProductRoute, deepLinks = listOf(navDeepLink {
        uriPattern = uri
    })
    ) {
        val viewModel = viewModel<DrinksListViewModel>()
        val uiState  by viewModel.uiState.collectAsState()
            ScreenProduct(
                products = uiState.products,
                onClick = {
                    navController.navigateToInfo(it.id)
                }
            )
        }
}
fun NavController.navigateToProduct(navOptions: NavOptions? = null) {
    navigate(ProductRoute, navOptions = navOptions)
}
