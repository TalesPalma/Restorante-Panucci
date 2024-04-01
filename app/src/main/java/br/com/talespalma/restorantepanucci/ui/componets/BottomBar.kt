package br.com.talespalma.restorantepanucci.ui.componets

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import br.com.talespalma.restorantepanucci.simpledates.SampleDate


@Composable
fun BottomBar() {
   val barItems = SampleDate.sampleDateBarItems
   var selectItem by remember {
       mutableStateOf("Home")
   }
    NavigationBar {
        barItems.forEach { item ->
            NavigationBarItem(
                selected = item.title == selectItem,
                onClick = {
                    selectItem = item.title },
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) },
            )
        }
    }
}


@Preview
@Composable
private fun BootomBarPreview() {
    BottomBar()
}