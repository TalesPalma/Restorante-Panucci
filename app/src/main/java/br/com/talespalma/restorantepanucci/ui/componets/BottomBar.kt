package br.com.talespalma.restorantepanucci.ui.componets

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.talespalma.restorantepanucci.navigation.HomeRoute
import br.com.talespalma.restorantepanucci.sampledates.BarItem
import br.com.talespalma.restorantepanucci.sampledates.SampleDate

@Composable
fun BottomBar(onClick:(BarItem) -> Unit = {}, selectItem: String = HomeRoute) {
   val barItems = SampleDate.sampleDateBarItems
    NavigationBar {
        barItems.forEach { item ->
            NavigationBarItem(
                selected = item.label == selectItem,
                onClick = { onClick(item)},
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(text = item.label) },
            )
        }
    }
}


@Preview
@Composable
private fun BootomBarPreview() {
    BottomBar()
}