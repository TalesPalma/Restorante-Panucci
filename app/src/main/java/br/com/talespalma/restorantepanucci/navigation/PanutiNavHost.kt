package br.com.talespalma.restorantepanucci.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


@Composable
fun PanutiNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        homeListScreen(navController)
        productListScreen(navController)
        cardapioListScreen(navController)
        infoScreen(navController)
        authentication(navController)
    }

}










