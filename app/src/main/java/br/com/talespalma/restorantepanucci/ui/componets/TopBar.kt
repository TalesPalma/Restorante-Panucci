package br.com.talespalma.restorantepanucci.ui.componets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(onClickExit:() ->Unit = {}) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Restorante Panucci") },
        actions = { IconButton(onClick = { onClickExit() }) {
            Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Exit")
        }}
    )
}

@Preview
@Composable
private fun TopAppBarPreview() {
    TopAppBar()
}