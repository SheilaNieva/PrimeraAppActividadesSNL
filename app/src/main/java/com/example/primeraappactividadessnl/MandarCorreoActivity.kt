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
}