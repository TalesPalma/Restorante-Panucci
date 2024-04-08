package br.com.talespalma.restorantepanucci.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenCardapio


internal const val cardapioRoute = "cardapio"
fun NavGraphBuilder.cardapioListScreen(navController: NavHostController) {
    composable(route = cardapioRoute) {
        ScreenCardapio {
            navController.navigateToInfo(it.id.toString())
        }
    }
}

fun NavController.navigateToCardapio(navOptions: NavOptions? = null) {
    navigate(cardapioRoute,navOptions = navOptions)
}
