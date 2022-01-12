package com.catfactscomposemvvm.network

import com.catfactscomposemvvm.domain.Breed
import com.catfactscomposemvvm.domain.Breeds
import com.catfactscomposemvvm.domain.Catfact
import com.catfactscomposemvvm.domain.Link

data class BreedsDto(
    val current_page: Int,
    val data: List<BreedDto>,
    val first_page_url: String? = null,
    val from: Int,
    val last_page: Int,
    val last_page_url: String? = null,
    val links: List<Link>,
    val next_page_url: String? = null,
    val path: String,
    val per_page: Int,
    val prev_page_url: String? = null,
    val to: Int,
    val total: Int
)

fun BreedsDto.toBreed() : List<Breed>
{
    var list = ArrayList<Breed>()
    for (breed in data)
        list.add(breed.toBreed())

    return list
}