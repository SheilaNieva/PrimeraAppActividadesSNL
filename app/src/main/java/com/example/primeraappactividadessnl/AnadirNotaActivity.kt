package com.example.primeraappactividadessnl


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_anadir_nota.*

class AnadirNotaActivity : AppCompatActivity() {

    //Declaracion de variables
    private var titulo:String=""
    private var mensaje:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_nota)

        val actionbar = supportActionBar
        actionbar!!.title = "Añadir Nota"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        btnNotaAnadirNota.setOnClickListener{
            this.titulo = etNotaTitulo.text.toString()
            this.mensaje = etNotaMensaje.text.toString()

           // createNote(titulo,mensaje)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    /*fun createNote(subject: String, text: String) {
        val intent = Intent(NoteIntents.ACTION_CREATE_NOTE).apply {
            putExtra(NoteIntents.EXTRA_NAME, subject)
            putExtra(NoteIntents.EXTRA_TEXT, text)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }*/
}