package br.com.talespalma.restorantepanucci.dao

import br.com.talespalma.restorantepanucci.model.Product
import br.com.talespalma.restorantepanucci.sampledates.SampleDate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDao{
    val productDrinks  = MutableStateFlow(SampleDate.sampleBebida).asStateFlow()
    val productFoods  = MutableStateFlow(SampleDate.cardapio).asStateFlow()
    fun findById(id: String) = if(id.toInt() <= 4) {
        productDrinks.value.find { it.id == id.toInt() }
    }
    else productFoods.value.find { it.id == id.toInt() }

}