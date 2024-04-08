package br.com.talespalma.restorantepanucci.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenProduct



internal const val ProductRoute = "product"
fun NavGraphBuilder.productListScreen(navController: NavHostController) {
    composable(route = ProductRoute) {
        ScreenProduct {
            navController.navigateToInfo(it.id.toString())
        }
    }
}
fun NavController.navigateToProduct(navOptions: NavOptions? = null) {
    navigate(ProductRoute, navOptions = navOptions)
}
