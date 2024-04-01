package br.com.talespalma.restorantepanucci.simpledates

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.talespalma.restorantepanucci.R
import java.net.URL


data class BarItem(val title: String, val icon: ImageVector)
data class Bebidas(val title: String, val image:Int, val description: String)
object SampleDate {

    val sampleDateBarItems = listOf(
        BarItem(
            title = "Home",
            icon = Icons.Default.Home
        ),
        BarItem(
            title = "Bebidas",
            icon = Icons.Default.ArrowDropDown
        ),
        BarItem(
            title = "Cardapio",
            icon = Icons.Default.DateRange
        )
    )

    val sampleBebida = listOf(
        Bebidas(
            title = "Coca Cola",
            image = R.drawable.cocacola,
            description = "Coca Cola"
        ),
        Bebidas(
            title = "Pepis",
            image = R.drawable.cocacola,
            description = "Pepis deliciosa"
        )
    )



}