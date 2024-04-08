package br.com.talespalma.restorantepanucci.ui.screnns

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenHome() {
    Column(Modifier.fillMaxSize()){
        Text(
            text = "Home",
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp,
            fontFamily = FontFamily.Default,
            modifier = Modifier.align( Alignment.CenterHorizontally),
        )
        Image(
            imageVector = Icons.Default.Home,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterHorizontally)
                .size(150.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ScreenHomePreview() {
    ScreenHome()
}