package com.catfactscomposemvvm.network

import com.catfactscomposemvvm.domain.Catfact

data class CatfactDto(
    val fact: String,
    val length: Int
)

fun CatfactDto.toCatfact() : Catfact{
    return Catfact(fact, length)
}
