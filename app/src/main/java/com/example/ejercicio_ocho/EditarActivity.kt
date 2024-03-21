package com.example.ejercicio_ocho

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditarActivity : AppCompatActivity() {

    var posicion: Int = 0
    lateinit var txtName: EditText
    lateinit var txtPhoneNumber: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val txtTitle = findViewById<TextView>(R.id.txtTitle)
        txtTitle.text = "Modificar Contacto"
        posicion = intent.getIntExtra("pocision", -1)
        Log.e("Contactos", "Se recibio un ${posicion}")
        txtName = findViewById(R.id.txtName)
        txtPhoneNumber = findViewById(R.id.txtPhoneNomber)

        val contact = ProvicionalData.listContact[posicion]
        txtName.setText(contact.name)
        txtPhoneNumber.setText(contact.phoneNumber)

    }
    fun save(v: View) {
        val contact = Contact(txtName.text.toString(), txtPhoneNumber.text.toString())
        ProvicionalData.listContact.set(posicion, contact)
        Toast.makeText(this, "Se modifico", Toast.LENGTH_LONG).show()
        finish()
    }
}