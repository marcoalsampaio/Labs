package com.example.labs.api


data class pais(
    val name: Name,
    val currencies: Currency,
    val capital: String,
)
data class Address(
    val city: String,
    val zipcode: String
)
data class Name(
    val nativeName: Common
)
data class Common(
    val common: String
)
data class Currency(
    val symbol: String
)