package com.example.labs.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table") //Entidade, tabela da base de dados! pode se modificar o nome da tabela
class Person(
    @PrimaryKey //Defenir nome como chave primaria
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "idade") val idade: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "ano") val ano: String
)

//Defenição da tabela na base de dados, modelo!