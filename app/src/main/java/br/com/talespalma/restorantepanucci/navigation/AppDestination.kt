package br.com.talespalma.restorantepanucci.navigation

sealed class AppDestination(val route:String){
    object Home: AppDestination("home")
    object Cardapio: AppDestination("cardapio")
    object Infos: AppDestination("infos")
    object Product: AppDestination("product")
}