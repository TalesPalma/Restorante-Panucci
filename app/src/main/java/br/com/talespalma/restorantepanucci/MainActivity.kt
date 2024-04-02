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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.talespalma.restorantepanucci.navigation.AppDestination
import br.com.talespalma.restorantepanucci.simpledates.Item
import br.com.talespalma.restorantepanucci.simpledates.SampleDate
import br.com.talespalma.restorantepanucci.ui.componets.BottomBar
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenCardapio
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenHome
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenInfos
import br.com.talespalma.restorantepanucci.ui.screnns.ScreenProduct
import br.com.talespalma.restorantepanucci.ui.theme.RestorantePanucciTheme

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
    var produto by remember {
        mutableStateOf(Item( title = "Coca-cola", description = "Coca-cola", image = R.drawable.cocacola))
    }
    val navController = rememberNavController()
    val currentBackStackEntryState by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntryState?.destination?.route
    val selectItem by remember(currentDestination) {
        val item = currentDestination?.let { current ->
            SampleDate.sampleDateBarItems.find {
              current.equals( it.destination)
          }
        } ?: SampleDate.sampleDateBarItems.first()
        mutableStateOf(item.destination)
    }
    Scaffold(
        bottomBar = {
            BottomBar(selectItem = selectItem,onClick = {
                    navController.navigate(it){
                        popUpTo(it)
                        launchSingleTop = true
                    }
            })
         },
        content = {
            Box(modifier = Modifier.padding(it)){
              NavHost(navController = navController, startDestination = AppDestination.Home.route ) {
                  composable(route = AppDestination.Home.route) {
                      ScreenHome()
                  }
                  composable(route = AppDestination.Product.route) {
                          ScreenProduct(){
                              navController.navigate(AppDestination.Infos.route){
                                  popUpTo(AppDestination.Infos.route){inclusive = true}
                              }
                              produto = it
                          }
                  }
                  composable(route = AppDestination.Cardapio.route) {
                      ScreenCardapio(){
                          navController.navigate(AppDestination.Infos.route){
                              popUpTo(AppDestination.Infos.route){inclusive = true}
                          }
                          produto = it
                      }
                  }
                  composable(route = AppDestination.Infos.route) {
                      ScreenInfos(product = produto,
                          onClickButton = {
                          navController.navigate(AppDestination.Home.route){
                              popUpTo(AppDestination.Home.route){inclusive = true}
                          }
                        }
                      )
                  }
              }
            }
        })
}

@Preview
@Composable
private fun AppPreview() {
    App()
}


