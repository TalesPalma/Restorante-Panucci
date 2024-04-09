package br.com.talespalma.restorantepanucci.dao

import br.com.talespalma.restorantepanucci.model.Product
import br.com.talespalma.restorantepanucci.sampledates.SampleDate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDao{
    private val totalList = SampleDate.sampleBebida + SampleDate.cardapio
    val product  = MutableStateFlow(totalList).asStateFlow()
    fun findById(id: String) = totalList.find { it.id == id.toInt() }
}