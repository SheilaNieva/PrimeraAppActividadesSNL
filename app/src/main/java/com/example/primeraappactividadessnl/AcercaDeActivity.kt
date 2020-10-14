package com.example.primeraappactividadessnl

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_acerca_de.*


class AcercaDeActivity : AppCompatActivity() {
    private var urlTW:String="https://twitter.com/SheilaNievaLo"
    private var urlGit:String="https://github.com/SheilaNieva"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acerca_de)

        val actionbar = supportActionBar
        actionbar!!.title = "Acerca de"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        ivAcercaDeTw.setOnClickListener{
            val uri: Uri = Uri.parse(urlTW)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        ivAcercaDeGit.setOnClickListener{
            val uri: Uri = Uri.parse(urlGit)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}