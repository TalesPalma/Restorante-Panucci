package br.com.talespalma.restorantepanucci.navigation

import PrincipalRouteGraph
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import principalGraph


@Composable
fun PanutiNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = PrincipalRouteGraph
    ) {
        principalGraph(navController)
        infoScreen(navController)
        authentication(navController)
    }

}











