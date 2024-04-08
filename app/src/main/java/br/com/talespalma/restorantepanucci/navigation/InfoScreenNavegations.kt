package br.com.talespalma.restorantepanucci.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.talespalma.restorantepanucci.sampledates.SampleDate
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenInfos


private const val InfoRoute = "infos"
fun NavGraphBuilder.infoScreen(navController: NavHostController) {
    composable(
        route = "$InfoRoute/{productId}"
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getString("productId") ?: "0"
        val listas = SampleDate.cardapio + SampleDate.sampleBebida
        listas.find { it.id == id.toInt() }?.let { product ->
            ScreenInfos(product,
                onClickButton = { navController.popBackStack() }
            )
        } ?: LaunchedEffect(key1 = Unit) {
            navController.navigateUp()
        }
    }
}


fun NavController.navigateToInfo(id: String) {
    navigate("$InfoRoute/$id")
}
