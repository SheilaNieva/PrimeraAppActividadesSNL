package com.example.primeraappactividadessnl



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.actions.NoteIntents
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
            Log.i("hola","Entra aqui")
            createNote(titulo,mensaje)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun createNote(subject: String, text: String) {
        val intent = Intent(NoteIntents.ACTION_CREATE_NOTE).apply {
            putExtra(NoteIntents.EXTRA_NAME, subject)
            putExtra(NoteIntents.EXTRA_TEXT, text)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
            Log.i("hola","Entra aqui 3")
        }
    }

    // Para salvar el estado por ejemplo es usando un Bundle en el ciclo de vida
    override fun onSaveInstanceState(outState: Bundle) {
        // Salvamos en un bundle estas variables o estados de la interfaz
        outState.run {
            // Actualizamos los datos o los recogemos de la interfaz

            putString("titulo", titulo)
            putString("mensaje", mensaje)

        }
        // Siempre se llama a la superclase para salvar as cosas
        super.onSaveInstanceState(outState)
    }

    // Para recuperar el estado al volver al un estado de ciclo de vida de la Interfaz
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Recuperamos en un bundle estas variables o estados de la interfaz
        super.onRestoreInstanceState(savedInstanceState)
        // Recuperamos del Bundle
        savedInstanceState.run {

            titulo = getString("titulo").toString()
            mensaje = getString("mensaje").toString()

        }
    }
}