package br.com.talespalma.restorantepanucci.ui.componets

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.talespalma.restorantepanucci.navigation.AppDestination
import br.com.talespalma.restorantepanucci.sampledates.SampleDate


@Composable
fun BottomBar(onClick:(String) -> Unit = {},selectItem:AppDestination) {
   val barItems = SampleDate.sampleDateBarItems
    NavigationBar {
        barItems.forEach { item ->
            NavigationBarItem(
                selected = item.destination == selectItem,
                onClick = { onClick(item.destination.route)},
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(text = item.label) },
            )
        }
    }
}


@Preview
@Composable
private fun BootomBarPreview() {
    BottomBar(selectItem = AppDestination.Home)
}