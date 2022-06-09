package com.example.labs.repository

import androidx.annotation.WorkerThread
import com.example.labs.dao.PersonDao
import com.example.labs.model.Person
import kotlinx.coroutines.flow.Flow

//camada de abstração extra
//Aceder e modificar a bd em conjuntoo com o DAO
class PersonRepository(private val personDao: PersonDao) {

    val allPeople: Flow<List<Person>> = personDao.getOrderedPeople()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread //Thread a parte
    suspend fun insert(person: Person){
        personDao.insert(person)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread //Thread a parte
    suspend fun delete(){
        personDao.delete20()
    }


}