package com.catfactscomposemvvm.network

import com.catfactscomposemvvm.domain.Breed

data class BreedDto(
    val breed: String,
    val country: String,
    val origin: String,
    val coat: String,
    val pattern: String
)

fun BreedDto.toBreed() : Breed{
    return Breed(breed, country, origin, coat, pattern)
}