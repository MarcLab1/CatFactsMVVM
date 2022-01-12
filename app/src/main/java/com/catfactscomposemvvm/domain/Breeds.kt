package com.catfactscomposemvvm.domain

data class Breeds(
    val current_page: Int,
    val data: List<Breed>,
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