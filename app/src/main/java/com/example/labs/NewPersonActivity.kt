package com.example.labs

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.example.labs.dao.PersonDao

class NewPersonActivity : AppCompatActivity() {


    private lateinit var editPersonName: EditText
    private lateinit var editPersonIdade: EditText
    private lateinit var editPersonEmail: EditText
    private lateinit var editPersonAno: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_person)
        editPersonName = findViewById(R.id.edit_person)
        editPersonIdade = findViewById(R.id.edit_idade)
        editPersonEmail = findViewById(R.id.edit_email)
        editPersonAno = findViewById(R.id.edit_ano)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editPersonName.text) || TextUtils.isEmpty(editPersonIdade.text) || TextUtils.isEmpty(editPersonEmail.text) || TextUtils.isEmpty(editPersonAno.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {

                replyIntent.putExtra(EXTRA_NAME, editPersonName.text.toString())
                replyIntent.putExtra(EXTRA_IDADE, editPersonIdade.text.toString())
                replyIntent.putExtra(EXTRA_EMAIL, editPersonEmail.text.toString())
                replyIntent.putExtra(EXTRA_ANO, editPersonAno.text.toString())

                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_NAME = "com.example.android.wordlist.NAME"
        const val EXTRA_IDADE = "com.example.android.wordlist.IDADE"
        const val EXTRA_EMAIL = "com.example.android.wordlist.EMAIL"
        const val EXTRA_ANO = "com.example.android.wordlist.ANO"
    }
}

