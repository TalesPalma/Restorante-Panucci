package br.com.talespalma.restorantepanucci.sampledates

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.talespalma.restorantepanucci.R
import br.com.talespalma.restorantepanucci.navigation.HomeRoute
import br.com.talespalma.restorantepanucci.navigation.ProductRoute
import br.com.talespalma.restorantepanucci.navigation.cardapioRoute


sealed class BarItem(
    val label: String,
    val icon: ImageVector,
) {
    object Home : BarItem(
        label = "Home",
        icon = Icons.Default.Home,
    )

    object Bebidas : BarItem(
        label = "Bebidas",
        icon = Icons.Default.ArrowDropDown,
    )

    object Cardapio : BarItem(
        label = "Cardapio",
        icon = Icons.Default.DateRange,
    )
}




data class Item(
    var title: String,
    val image: Int,
    val description: String,
    val id: Int
)

object SampleDate {

    val sampleDateBarItems:List<BarItem> = listOf(
        BarItem.Home,BarItem.Cardapio,BarItem.Bebidas
    )

    val sampleBebida = listOf(
        Item(
            title = "Coca Cola",
            image = R.drawable.bebidas,
            description = "Coca Cola",
            id = 1
        ),
        Item(
            title = "Pepis",
            image = R.drawable.bebidas,
            description = "Pepis deliciosa",
            id = 2
        ),
        Item(
            title = "Coca Cola",
            image = R.drawable.bebidas,
            description = "Coca Cola",
            id = 3
        ),
        Item(
            title = "Pepis",
            image = R.drawable.bebidas,
            description = "Pepis deliciosa",
            id = 4
        )
    )

    //Foods list
    val cardapio = listOf(
        Item(
            title = "Banco",
            image = R.drawable.alimentos,
            description = "bancon de porco",
            id = 5
        ),
        Item(
            title = "Frango",
            image = R.drawable.alimentos,
            description = "Frango",
            id = 6
        ),
        Item(
            title = "Macarrao",
            image = R.drawable.alimentos,
            description = "Macarrao",
            id = 7
        )
    )

}