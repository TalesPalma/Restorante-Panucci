package br.com.talespalma.restorantepanucci

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.talespalma.restorantepanucci.extensions.preferences.dataStore
import br.com.talespalma.restorantepanucci.extensions.preferences.userPreferences
import br.com.talespalma.restorantepanucci.navigation.AppDestination
import br.com.talespalma.restorantepanucci.navigation.PanutiNavHost
import br.com.talespalma.restorantepanucci.sampledates.SampleDate
import br.com.talespalma.restorantepanucci.ui.componets.BottomBar
import br.com.talespalma.restorantepanucci.ui.componets.TopAppBar
import br.com.talespalma.restorantepanucci.ui.screnns.AuthenticationScreen
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenCardapio
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenHome
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenInfos
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenProduct
import br.com.talespalma.restorantepanucci.ui.theme.RestorantePanucciTheme
import kotlinx.coroutines.flow.first
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
        val item = currentDestination?.let { current ->
            SampleDate.sampleDateBarItems.find {
                current.equals(it.destination)
            }
        } ?: SampleDate.sampleDateBarItems.first()
        mutableStateOf(item.destination)
    }
    Scaffold(
        topBar = { TopAppBar(onClickExit = {
            scope.launch {
                context.dataStore.edit {
                    it.remove(userPreferences)
                }
                navController.navigate(AppDestination.Authentication.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                }
            }
        }) },
        bottomBar = {
            if (currentDestination != AppDestination.Infos.route) {
                BottomBar(selectItem = selectItem, onClick = {
                    navController.navigate(it) {
                        popUpTo(it)
                        launchSingleTop = true
                    }
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


