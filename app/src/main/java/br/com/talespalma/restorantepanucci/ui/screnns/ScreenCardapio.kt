package br.com.talespalma.restorantepanucci.ui.screnns

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.talespalma.restorantepanucci.simpledates.Item
import br.com.talespalma.restorantepanucci.simpledates.SampleDate
import br.com.talespalma.restorantepanucci.ui.componets.ProductItem


@Composable
fun ScreenCardapio(onClick:(Item) -> Unit = {}) {
    Column(Modifier.fillMaxSize()){
        Text(
            text = "Cardapio",
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier.align( Alignment.CenterHorizontally)
        )
        LazyColumn {
            items(SampleDate.cardapio) { item ->
                ProductItem(product = item){ onClick(item) }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ScreenCardapioPreview() {
    ScreenCardapio()
}