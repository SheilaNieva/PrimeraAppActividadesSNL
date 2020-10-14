package com.example.primeraappactividadessnl

import android.content.Intent
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
                menuAnadirNota()
                true
            }
            R.id.menu_correo -> {
                menuMandarCorreo()
                true
            }
            R.id.menu_amigo -> {
                menuAnadirAmigo()
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

    private fun menuAnadirNota() {
        val intent = Intent(this, AnadirNotaActivity::class.java)
        startActivity(intent)
    }

    private fun menuMandarCorreo() {
        val intent = Intent(this, MandarCorreoActivity::class.java)
        startActivity(intent)
    }


    private fun menuAnadirAmigo() {
        val intent = Intent(this, AnadirContactoActivity::class.java)
        startActivity(intent)
    }
}