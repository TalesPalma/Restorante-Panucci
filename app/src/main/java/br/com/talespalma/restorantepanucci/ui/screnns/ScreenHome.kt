package br.com.talespalma.restorantepanucci.ui.screnns

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenHome() {
    Column(Modifier.fillMaxSize()){
        Text(
            text = "Home",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align( Alignment.CenterHorizontally)
                .offset(y = 300.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ScreenHomePreview() {
    ScreenHome()
}