package com.sample.jackdaniels.network

interface URLS {
    companion object {
        val BASE_URL = "https://api-project-952250395240.firebaseio.com"
        val ADD_PRODUCT = "$BASE_URL/JackDaniel/products/{new}.json"
        val GET_PRODUCTS = "$BASE_URL/JackDaniel.json"
    }

}
