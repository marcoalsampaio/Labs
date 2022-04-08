package com.example.labs.viewModel

import androidx.lifecycle.*
import com.example.labs.model.Person
import com.example.labs.repository.PersonRepository
import kotlinx.coroutines.launch

class PersonViewModel(private val repository: PersonRepository): ViewModel() {

    val allPeople: LiveData<List<Person>> = repository.allPeople.asLiveData()

    fun insert(person: Person) = viewModelScope.launch {
        repository.insert(person)
    }
}


//factory -> Design Patern

class PersonViewModelFactory(private val repository: PersonRepository): ViewModelProvider.Factory{ //Instanciar da forma correta!

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return PersonViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown View Model Class")
    }

}