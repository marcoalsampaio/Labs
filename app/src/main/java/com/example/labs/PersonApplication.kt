package com.example.labs

import android.app.Application
import com.example.labs.db.PersonRoomDatabase
import com.example.labs.repository.PersonRepository

class PersonApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { PersonRoomDatabase.getDatabase(this) }
    val repository by lazy { PersonRepository(database.personDao()) }
}