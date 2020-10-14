package com.example.primeraappactividadessnl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import kotlinx.android.synthetic.main.activity_anadir_contacto.*
import kotlinx.android.synthetic.main.activity_mandar_correo.*

class AnadirContactoActivity : AppCompatActivity() {

    //Declaracion de variables
    private var nombre:String=""
    private var email:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_contacto)


        val actionbar = supportActionBar
        actionbar!!.title = "Añadir Contacto"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        //Llamamos al boton añadir contacto, pasandole todos los datos (nombre, email)
        btnContactoAnadir.setOnClickListener{
            this.nombre = etContactoNombre.text.toString()
            this.email = etContactoEmail.text.toString()

            insertContact(nombre,email)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun insertContact(name: String, email: String) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
            putExtra(ContactsContract.Intents.Insert.NAME, name)
            putExtra(ContactsContract.Intents.Insert.EMAIL, email)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}