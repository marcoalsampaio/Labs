package com.example.labs.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.labs.dao.PersonDao
import com.example.labs.model.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.security.AccessControlContext

//Tabelas               //Version - Migrações      //
@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class PersonRoomDatabase : RoomDatabase() { //vai reprsentar a base de dados e vai se criar a base de dados em si
                                    //Para utilizar metodos de uma base de dados room
    //Instanciar a base de daods 1 x "Singleton" uma unica instacia na base de dados inteira (Design Patern)

    abstract fun personDao(): PersonDao //Interagir como fossem getters em java

    private class PersonDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.personDao())
                }
            }
        }

        suspend fun populateDatabase(PersonDao: PersonDao) {
            // Delete all content here.

            // Add sample words.
            var person = Person("Hello")
            PersonDao.insert(person)

            // TODO: Add your own words!
        }
    }
    //Singleton - Instaciar 1 x e dps ir sempre buscala
    companion object{ //Todos os metodos e var defenidos, ser acedidos sem instanciar

        @Volatile //Caso mude, notifica as threads (insert, ou codigo (suspend!!!) para nao haver descrepancias)
        private var INSTANCE: PersonRoomDatabase? = null //Criar a instancia

        //Criar função para ir buscar a BD e caso nao exista cirar a bd

        fun getDatabase(context: Context, scope: CoroutineScope): PersonRoomDatabase{
            return  INSTANCE ?: synchronized(this){
                //Criar a base de dados
                val instance = Room.databaseBuilder(
                    context.applicationContext, //Contexto de toda a aplicação
                    PersonRoomDatabase:: class.java, //class da base de dados
                    "person_database" //Nome da base de dados
                ).addCallback(PersonDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance //Nao e preciso return, deixar so o instance
            }

        }
    }

}