package br.com.talespalma.restorantepanucci.ui.screnns

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ErrorScreen(errorOnSucess: () -> Unit) {
//    Centralizar meu button e text de volta para a tela anterior
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Error!!",
            fontSize = 40.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )
        Button(onClick = errorOnSucess) {
            Text(text = "Retornar", fontSize = 30.sp)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ErrorScreenPreview() {
    ErrorScreen({})
}