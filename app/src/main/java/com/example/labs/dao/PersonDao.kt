package com.example.labs.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.example.labs.model.Person
import kotlinx.coroutines.flow.Flow

@Dao //Unica coisa que acede a bd de dados, criamos os metodos que acedem a base de dados
interface PersonDao { //Criar querys sql e associar aos metodos

    @Query("SELECT * FROM person_table ORDER BY name ASC")
    fun getOrderedPeople(): Flow<List<Person>> //FLow -> ter sempre a informação utilizada

    @Insert(onConflict = IGNORE) //Caso exista repetidos, ignorar
    suspend fun insert(person: Person) //suspend -> Corre a parte do restante codigo, para casoa conteça algo de mal nao se aperceber
    //suspend sempre que se faz modificções a base de dados

    @Query("DELETE FROM person_table where idade > 20")
    suspend fun delete20()

   /* @Query("SELECT * FROM person_table WHERE name like B%")
    suspend fun getByB(): Flow<List<Person>>*/
}