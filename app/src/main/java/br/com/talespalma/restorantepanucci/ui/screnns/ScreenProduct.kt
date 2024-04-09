package br.com.talespalma.restorantepanucci.ui.screnns

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.talespalma.restorantepanucci.model.Product
import br.com.talespalma.restorantepanucci.sampledates.SampleDate
import br.com.talespalma.restorantepanucci.ui.componets.ProductItem


@Composable
fun ScreenProduct(onClick: (Product) -> Unit = {}) {
    LazyColumn {
        items(SampleDate.sampleBebida) { item ->
            ProductItem(product = item) { onClick(item) }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun SecreenProductPreview() {
    ScreenProduct()
}
