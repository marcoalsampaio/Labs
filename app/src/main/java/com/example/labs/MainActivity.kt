package com.example.labs

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labs.adapters.PersonAdapter
import com.example.labs.model.Person
import com.example.labs.viewModel.PersonViewModel
import com.example.labs.viewModel.PersonViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    private val newPersonActivityRequestCode = 1
    private val personViewModel: PersonViewModel by viewModels {
        PersonViewModelFactory((application as PersonApplication).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = PersonAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)



        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        personViewModel.allPeople.observe(this, Observer { persons ->
            // Update the cached copy of the words in the adapter.
            persons.let { adapter.submitList(it) }
        })

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewPersonActivity::class.java)
            startActivityForResult(intent, newPersonActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newPersonActivityRequestCode && resultCode == Activity.RESULT_OK) {
            val name = intentData?.getStringExtra(NewPersonActivity.EXTRA_NAME)
            val idade = intentData?.getStringExtra(NewPersonActivity.EXTRA_IDADE)
            val email = intentData?.getStringExtra(NewPersonActivity.EXTRA_EMAIL)


            val person = Person(name!!, idade!!, email!!)
            personViewModel.insert(person)
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }

}


