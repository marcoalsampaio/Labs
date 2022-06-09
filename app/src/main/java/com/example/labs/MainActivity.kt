package com.example.labs

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //Bom para informações pequenas (Microfone ativo, Som, ect) Mau para outras informaoes tipo lista etc etc etc
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreference: SharedPreferences = getSharedPreferences("FILE_1", Context.MODE_PRIVATE)
        //Aceder ao ficheiro que guarda as shared preferences //Mode private, só acedido por esta aplicação

        //Verificar se existe Login feito
        val usernameValue = sharedPreference.getString("PREF_USERNAME", "")
        //Se nao existir, cria vazio para dps ser preenchido

        Log.d("SHARED_PREF_AULA", "shared preference: $usernameValue")

        if(usernameValue!!.isNotEmpty()){ //!! assumir que a varivael tem sempre valor
            showWelcome(usernameValue) //Chanfe textview to username and logout button
        }
    }

    private fun showWelcome(usernameValue: String) {
        findViewById<TextView>(R.id.textViewUsername).text = usernameValue //Mudar valor para Ola username, Problemas de segurnaças, user input
        findViewById<EditText>(R.id.editTextUsername).isEnabled = false //Colocar disable

        val submitButton = findViewById<Button>(R.id.buttonSubmitUsername) //Change Text and click
        submitButton.text = "button"
        submitButton.setOnClickListener {
            logout(it) //Interavel IT
        }
    }

    private fun logout(view: View) {
        val sharedPreference: SharedPreferences = getSharedPreferences("FILE_1", Context.MODE_PRIVATE) //Try catch
        sharedPreference.edit() //Eliminar todos os dados do shared preferences
            .clear()
            .apply()
        showLogin()
        Log.d("SHARED_PREF_AULA", "shared preference: ")
    }

    private fun showLogin() {
        findViewById<TextView>(R.id.textViewUsername).text = "Inexistente" //Mudar valor para Ola username, Problemas de segurnaças, user input
        findViewById<EditText>(R.id.editTextUsername).isEnabled = true //Colocar disable

        val submitButton = findViewById<Button>(R.id.buttonSubmitUsername) //Change Text and click
        submitButton.text = "Button"
        submitButton.setOnClickListener {
            save(it) //Interavel IT - View onde se encontra o butão
        }
    }

    fun save(view: View) {
        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        if(editTextUsername.text.isNotEmpty()){
            val sharedPreference: SharedPreferences = getSharedPreferences("FILE_1", Context.MODE_PRIVATE) //Acesso ao ficheiro
            sharedPreference.edit()
                .putString("PREF_USERNAME", editTextUsername.text.toString()) //Guardar o username no shared preferences
                .apply() //PAra guardar a informacção, !! Sempre necessario!!!!!

            showWelcome(editTextUsername.text.toString()) //Chamar show welcome para muudar o layout do ecra
            Log.d("SHARED_PREF_AULA", "shared preference: ${editTextUsername.text}")
        }
    }
}