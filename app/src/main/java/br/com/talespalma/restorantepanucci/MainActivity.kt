package br.com.talespalma.restorantepanucci

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import br.com.talespalma.restorantepanucci.extensions.preferences.dataStore
import br.com.talespalma.restorantepanucci.extensions.preferences.userPreferences
import br.com.talespalma.restorantepanucci.navigation.HomeRoute
import br.com.talespalma.restorantepanucci.navigation.InfoRoute
import br.com.talespalma.restorantepanucci.navigation.PanutiNavHost
import br.com.talespalma.restorantepanucci.navigation.ProductRoute
import br.com.talespalma.restorantepanucci.navigation.cardapioRoute
import br.com.talespalma.restorantepanucci.navigation.navigateToAuthentication
import br.com.talespalma.restorantepanucci.sampledates.BarItem
import br.com.talespalma.restorantepanucci.ui.componets.BottomBar
import br.com.talespalma.restorantepanucci.ui.componets.TopAppBar
import br.com.talespalma.restorantepanucci.ui.theme.RestorantePanucciTheme
import kotlinx.coroutines.launch
import navigateSingleTopWithPopUpTo


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestorantePanucciTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun App() {
    val navController = rememberNavController()
    val currentBackStackEntryState by navController.currentBackStackEntryAsState()

    val messaDone = currentBackStackEntryState
        ?.savedStateHandle
        ?.getStateFlow<String?>("product-message", null)
        ?.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    scope.launch {
        messaDone?.value?.let { message ->
            snackbarHostState.showSnackbar(message = message)
        }
    }

    val currentDestination = currentBackStackEntryState?.destination?.route
    val context = LocalContext.current
    val selectItem by remember(currentDestination) {
        val item = when (currentDestination) {
            HomeRoute -> BarItem.Home
            ProductRoute -> BarItem.Bebidas
            cardapioRoute -> BarItem.Cardapio
            else -> BarItem.Home
        }
        mutableStateOf(item)
    }
    Scaffold(snackbarHost ={
        SnackbarHost(hostState = snackbarHostState){ data ->
            Snackbar{
                Text(tex= data.visuals.message)
            }
        }
    }
        ,topBar = {
        TopAppBar(onClickExit = {
            scope.launch {
                context.dataStore.edit {
                    it.remove(userPreferences)
                }
                navController.navigateToAuthentication()
            }
        })
    }, bottomBar = {
        if (currentDestination != InfoRoute) {
            BottomBar(selectItem = selectItem.label, onClick = { item ->
                navController.navigateSingleTopWithPopUpTo(item)
            })
        }
    }, content = {
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





