package com.example.labs.models
import java.time.LocalDate

//DTO (Ter so informação)
data class Todo (
    //val title: String,
    //val date: LocalDate
    val pais: String,
    val capital: String,
    val habitantes: Number,
    val n_distritos: Number,
    val n_freguesias: Number,
    ){
}