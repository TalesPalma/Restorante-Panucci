package br.com.talespalma.restorantepanucci.simpledates

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.talespalma.restorantepanucci.R
import br.com.talespalma.restorantepanucci.navigation.AppDestination


data class BarItem(
    val label: String,
    val icon: ImageVector,
    val destination: AppDestination
)
data class Item(
    var title: String,
    val image: Int,
    val description: String,
    val id: Int
)
object SampleDate {

    val sampleDateBarItems = listOf(
        BarItem(
            label = "Home",
            icon = Icons.Default.Home,
            destination = AppDestination.Home
        ),
        BarItem(
            label = "Bebidas",
            icon = Icons.Default.ArrowDropDown,
            destination = AppDestination.Product
        ),
        BarItem(
            label = "Cardapio",
            icon = Icons.Default.DateRange,
            destination = AppDestination.Cardapio
        )
    )

    val sampleBebida = listOf(
        Item(
            title = "Coca Cola",
            image = R.drawable.cocacola,
            description = "Coca Cola",
            id = 1
        ),
        Item(
            title = "Pepis",
            image = R.drawable.cocacola,
            description = "Pepis deliciosa",
            id = 2
        ),
        Item(
            title = "Coca Cola",
            image = R.drawable.cocacola,
            description = "Coca Cola",
            id = 3
        ),
        Item(
            title = "Pepis",
            image = R.drawable.cocacola,
            description = "Pepis deliciosa",
            id = 4
        )
    )
//Foods list
  val cardapio = listOf(
        Item(
            title = "Banco",
            image = R.drawable.cocacola,
            description = "bancon de porco",
            id = 5
        ),
      Item(
          title = "Frango",
          image = R.drawable.cocacola,
          description = "Frango",
          id = 6
      ),
      Item(
          title = "Macarrao",
          image = R.drawable.cocacola,
          description = "Macarrao",
          id = 7
      )
  )

}