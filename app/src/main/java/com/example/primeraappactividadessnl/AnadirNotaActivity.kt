package com.example.primeraappactividadessnl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AnadirNotaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_nota)

        val actionbar = supportActionBar
        actionbar!!.title = "Añadir Nota"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}