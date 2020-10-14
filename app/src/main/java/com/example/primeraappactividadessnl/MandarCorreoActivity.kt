package com.example.primeraappactividadessnl

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mandar_correo.*

class MandarCorreoActivity : AppCompatActivity() {

    //Declaracion de variables
    private var asunto:String=""
    private var mensaje:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mandar_correo)

        //Llamamos al boton enviar, pasandole todos los datos
        btnCorreoEnviar.setOnClickListener{
            val destinatario = arrayOf (etCorreoDestinatario.text.toString())
            this.asunto = etCorreoAsunto.text.toString()
            this.mensaje = etCorreoMensaje.text.toString()

            composeEmail(destinatario,asunto,mensaje)
        }

        //Flecha para volver atrás
        val actionbar = supportActionBar
        actionbar!!.title = "Mandar Correo"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun composeEmail(destinatario: Array<String>, asunto: String, mensaje : String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, destinatario)
            putExtra(Intent.EXTRA_SUBJECT, asunto)
            putExtra(Intent.EXTRA_TEXT, mensaje)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    // Para salvar el estado por ejemplo es usando un Bundle en el ciclo de vida
    override fun onSaveInstanceState(outState: Bundle) {
        // Salvamos en un bundle estas variables o estados de la interfaz
        outState.run {
            // Actualizamos los datos o los recogemos de la interfaz

            putString("asunto", asunto)
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

            asunto = getString("asunto").toString()
            mensaje = getString("mensaje").toString()

        }
    }
}