package com.catfactscomposemvvm.network

import com.catfactscomposemvvm.domain.Catfact

data class CatfactsDto(
    val current_page: Int,
    val data: List<CatfactDto>,
    val first_page_url: String,
    val from: Int,
    val last_page: Int,
    val last_page_url: String,
    val links: List<Link>,
    val next_page_url: String,
    val path: String,
    val per_page: Int,
    val prev_page_url: Any,
    val to: Int,
    val total: Int
)

fun CatfactsDto.toCatfacts() : List<Catfact>
{
    var list = ArrayList<Catfact>()
    for (catfactDto in data)
        list.add(catfactDto.toCatfact())

    return list
}