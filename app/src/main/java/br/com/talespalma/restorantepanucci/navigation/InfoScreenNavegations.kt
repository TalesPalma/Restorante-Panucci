package br.com.talespalma.restorantepanucci.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.alura.panucci.ui.viewmodels.ProductDetailsViewModel
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenInfos


internal const val InfoRoute = "infos"
fun NavGraphBuilder.infoScreen(navController: NavHostController) {
    composable(
        route = "$InfoRoute/{productId}"
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getString("productId")?.toInt() ?: 0
        val viewModel = viewModel<ProductDetailsViewModel>()
        ScreenInfos(
            viewModel.findProductById(id.toString())
        ) { navController.popBackStack() }
    }
}


fun NavController.navigateToInfo(id: Int, navOptions: NavOptions? = null) {
    navigate("$InfoRoute/$id", navOptions = navOptions)
}
