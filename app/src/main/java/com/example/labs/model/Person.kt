package com.example.labs.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table") //Entidade, tabela da base de dados! pode se modificar o nome da tabela
class Person(
    @PrimaryKey //Defenir nome como chave primaria
    @ColumnInfo(name = "name") //Modificar as colunas
    val name: String
    )

//Defenição da tabela na base de dados, modelo!