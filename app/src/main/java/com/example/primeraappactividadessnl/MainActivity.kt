package com.example.primeraappactividadessnl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.menu_nota -> {
                //menuAcercaDe()
                true
            }
            R.id.menu_correo -> {
                //menuAcercaDe()
                true
            }
            R.id.menu_amigo -> {
                //menuAcercaDe()
                true
            }
            R.id.menu_cita -> {
                //menuAcercaDe()
                true
            }
            R.id.menu_acercade -> {
                //menuOtraOpcion()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}