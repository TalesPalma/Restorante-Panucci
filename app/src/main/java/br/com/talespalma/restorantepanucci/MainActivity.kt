package br.com.talespalma.restorantepanucci

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.preferences.core.edit
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import br.com.talespalma.restorantepanucci.extensions.preferences.dataStore
import br.com.talespalma.restorantepanucci.extensions.preferences.userPreferences
import br.com.talespalma.restorantepanucci.navigation.HomeRoute
import br.com.talespalma.restorantepanucci.navigation.InfoRoute
import br.com.talespalma.restorantepanucci.navigation.PanutiNavHost
import br.com.talespalma.restorantepanucci.navigation.ProductRoute
import br.com.talespalma.restorantepanucci.navigation.cardapioRoute
import br.com.talespalma.restorantepanucci.navigation.navigateToAuthentication
import br.com.talespalma.restorantepanucci.navigation.navigateToCardapio
import br.com.talespalma.restorantepanucci.navigation.navigateToHome
import br.com.talespalma.restorantepanucci.navigation.navigateToProduct
import br.com.talespalma.restorantepanucci.sampledates.BarItem
import br.com.talespalma.restorantepanucci.ui.componets.BottomBar
import br.com.talespalma.restorantepanucci.ui.componets.TopAppBar
import br.com.talespalma.restorantepanucci.ui.theme.RestorantePanucciTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestorantePanucciTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    val currentBackStackEntryState by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntryState?.destination?.route
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val selectItem by remember(currentDestination) {
        val item = when (currentDestination) {
            HomeRoute -> BarItem.Home
            ProductRoute -> BarItem.Bebidas
            cardapioRoute -> BarItem.Cardapio
            else -> BarItem.Home
        }
        mutableStateOf(item)
    }
    Scaffold(
        topBar = {
            TopAppBar(onClickExit = {
                scope.launch {
                    context.dataStore.edit {
                        it.remove(userPreferences)
                    }
                    navController.navigateToAuthentication()
                }
            })
        },
        bottomBar = {
            if (currentDestination != InfoRoute) {
                BottomBar(selectItem = selectItem.label, onClick = {item ->
                    val (route, action) = when(item){
                        BarItem.Bebidas -> Pair(
                            ProductRoute,
                            navController::navigateToProduct
                        )
                        BarItem.Cardapio -> Pair(
                            cardapioRoute,
                            navController::navigateToCardapio
                        )
                        BarItem.Home -> Pair(
                            HomeRoute,
                            navController::navigateToHome
                        )
                    }
                    val navOpt = navOptions {
                        launchSingleTop = true
                        popUpTo(route)
                    }

                    action(navOpt)
                })
            }
        },
        content = {
            Box(modifier = Modifier.padding(it)) {
                PanutiNavHost(navController = navController)
            }
        })
}

@Preview
@Composable
private fun AppPreview() {
    App()
}


