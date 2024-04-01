package br.com.talespalma.restorantepanucci.ui.componets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.talespalma.restorantepanucci.simpledates.Bebidas
import br.com.talespalma.restorantepanucci.simpledates.SampleDate


@Composable
fun ProductItem(product: Bebidas) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(20.dp),
        colors = CardDefaults.cardColors(Color.White)
    ){
        Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = null,
                modifier = Modifier
                    .clip(RectangleShape)
                    .border(BorderStroke(20.dp, Color.Transparent), shape = RectangleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = product.title,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 20.sp,
                fontWeight = Bold
            )
            Text(text = "Descrição: " + product.description, maxLines = 2, modifier = Modifier.padding(16.dp).heightIn(50.dp))
        }
    }
}


@Preview
@Composable
private fun ProductItemPreview() {
    ProductItem(product = SampleDate.sampleBebida.first())
}
