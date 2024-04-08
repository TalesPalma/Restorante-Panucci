package br.com.talespalma.restorantepanucci.navigation

import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.preferences.core.edit
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.talespalma.restorantepanucci.extensions.preferences.dataStore
import br.com.talespalma.restorantepanucci.extensions.preferences.userPreferences
import br.com.talespalma.restorantepanucci.ui.screnns.AuthenticationScreen
import kotlinx.coroutines.launch


private const val AuthenticationRoute = "authentication"
fun NavGraphBuilder.authentication(navController: NavHostController) {
    composable(AuthenticationRoute) {
        val context = LocalContext.current
        val scope = rememberCoroutineScope()
        AuthenticationScreen { user ->
            scope.launch {
                context.dataStore.edit { preference ->
                    preference[userPreferences] = user
                }
            }
            navController.navigateToHome()
        }
    }
}
fun NavController.navigateToAuthentication(navOptions: NavOptions? = null) {
    navigate(AuthenticationRoute,navOptions = navOptions)
}
