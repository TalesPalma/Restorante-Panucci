package br.com.talespalma.restorantepanucci.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.talespalma.restorantepanucci.extensions.preferences.dataStore
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenHome
import kotlinx.coroutines.flow.first


internal const val HomeRoute = "home"
fun NavGraphBuilder.homeListScreen(navController: NavHostController) {
    composable(route = HomeRoute) {
        val userPreferences = stringPreferencesKey("usuario_logado")
        val context = LocalContext.current
        var user: String? by remember {
            mutableStateOf(null)
        }
        var dataState by remember {
            mutableStateOf("loading")
        }
        LaunchedEffect(null) {
            user = context.dataStore.data.first()[userPreferences]
            dataState = "finished"
        }
        when (dataState) {
            "loading" -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Carregando...",
                        Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        textAlign = TextAlign.Center
                    )
                }
            }

            "finished" -> {
                user?.let {
                    ScreenHome()
                } ?: LaunchedEffect(null) {
                    navController.navigateToAuthentication()
                }
            }
        }

    }
}

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    navigate(HomeRoute, navOptions = navOptions)
}