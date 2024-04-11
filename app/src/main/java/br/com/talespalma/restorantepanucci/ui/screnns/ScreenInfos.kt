package br.com.talespalma.restorantepanucci.ui.screnns

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.alura.panucci.ui.uistate.ProductDetailsUiState
import br.com.talespalma.restorantepanucci.sampledates.SampleDate


@Composable
fun ScreenInfos(
    uiState: ProductDetailsUiState?,
    onClickButton: () -> Unit = {},
) {
    when (uiState) {
        ProductDetailsUiState.Empty -> ErrorScreen(onClickButton)
        ProductDetailsUiState.Error -> ErrorScreen(onClickButton)
        ProductDetailsUiState.Loading -> ErrorScreen(onClickButton)
        is ProductDetailsUiState.Success -> {
            val product = uiState.product ?: SampleDate.sampleBebida.first()
            var number by remember {
                mutableStateOf("")
            }
            Column(modifier = Modifier.fillMaxSize()) {
                val alignment = Alignment.CenterHorizontally
                Text(
                    text = product.title,
                    modifier = Modifier
                        .align(alignment)
                        .offset(x = 2.dp, y = 30.dp),
                    fontFamily = FontFamily.Cursive,
                    fontSize = 40.sp
                )
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RectangleShape)
                        .align(Alignment.CenterHorizontally)
                        .padding(50.dp),
                    contentScale = ContentScale.Crop
                )
                TextField(
                    value = number,
                    onValueChange = { number = it },
                    modifier = Modifier
                        .align(alignment)
                        .padding(bottom = 16.dp),
                    placeholder = { Text(text = "Quatidade de ${product.title} desejada ") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
                Button(onClick = onClickButton, modifier = Modifier.align(alignment)) {
                    Text(text = "Confirmar")
                }
            }
        }
        null -> ErrorScreen(onClickButton)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ScreenInfosPreview() {
    ScreenInfos(null)
}