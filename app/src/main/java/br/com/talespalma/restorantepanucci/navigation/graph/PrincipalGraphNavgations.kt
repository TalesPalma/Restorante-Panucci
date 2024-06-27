import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import androidx.navigation.navigation
import br.com.talespalma.restorantepanucci.navigation.HomeRoute
import br.com.talespalma.restorantepanucci.navigation.cardapioListScreen
import br.com.talespalma.restorantepanucci.navigation.cardapioRoute
import br.com.talespalma.restorantepanucci.navigation.drinkRoute
import br.com.talespalma.restorantepanucci.navigation.homeListScreen
import br.com.talespalma.restorantepanucci.navigation.navigateToCardapio
import br.com.talespalma.restorantepanucci.navigation.navigateToHome
import br.com.talespalma.restorantepanucci.navigation.navigateToProduct
import br.com.talespalma.restorantepanucci.navigation.productListScreen
import br.com.talespalma.restorantepanucci.sampledates.BarItem



internal const val PrincipalRouteGraph = "principal"

fun NavController.navigateToPrincipalGraph(navOptions: NavOptions? = null) {
    navigate(PrincipalRouteGraph,navOptions = navOptions)
}

fun NavGraphBuilder.principalGraph(navController: NavHostController) {
    navigation(
        startDestination = HomeRoute,
        route = PrincipalRouteGraph
    ) {
        homeListScreen(navController)
        productListScreen(navController)
        cardapioListScreen(navController)
    }
}

 fun NavController.navigateSingleTopWithPopUpTo(
    item: BarItem,
) {
    val (route, action) = when (item) {
        BarItem.Bebidas -> Pair(
            drinkRoute,
            ::navigateToProduct
        )

        BarItem.Cardapio -> Pair(
            cardapioRoute,
            ::navigateToCardapio
        )

        BarItem.Home -> Pair(
            HomeRoute,
            ::navigateToHome
        )
    }
    val navOpt = navOptions {
        launchSingleTop = true
        popUpTo(route)
    }

    action(navOpt)
}