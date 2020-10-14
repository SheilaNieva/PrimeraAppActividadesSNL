package com.example.primeraappactividadessnl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import kotlinx.android.synthetic.main.activity_anadir_cita.*
import kotlinx.android.synthetic.main.activity_anadir_contacto.*

class AnadirCitaActivity : AppCompatActivity() {
    //Declaracion de variables
    private var titulo:String=""
    private var localizacion:String=""
    private var begin:Long=0
    private var end:Long=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_cita)

        val actionbar = supportActionBar
        actionbar!!.title = "Añadir Cita"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        btnCitaAñadir.setOnClickListener{
            this.titulo = etCitaTitulo.text.toString()
            this.localizacion = etCitaLocalizacion.text.toString()
            this.begin = etCitaBegin.drawingTime
            this.end = etCitaEnd.drawingTime

            addEvent(titulo,localizacion, begin, end)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun addEvent(title: String, location: String, begin: Long, end: Long) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, title)
            putExtra(CalendarContract.Events.EVENT_LOCATION, location)
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)
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

            putString("TITULO", titulo)
            putString("LOCALIZACION", localizacion)
            putLong("BEGIN", begin)
            putLong("END", end)

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

            titulo = getString("TITULO").toString()
            localizacion = getString("LOCALIZACION").toString()
            begin = getLong("BEGIN")
            end = getLong("END")

        }
    }
}