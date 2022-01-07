package com.catfactscomposemvvm.domain

import com.catfactscomposemvvm.network.CatfactDto

data class Catfact(val fact: String, val length: Int)

fun Catfact.toCatfactDto() : CatfactDto
{
    return CatfactDto(fact, length)
}