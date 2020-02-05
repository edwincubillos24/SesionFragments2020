package com.edwinacubillos.sesionfragments

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_superheroe_detalle.*
import kotlinx.android.synthetic.main.content_superheroe_detalle.*

class SuperheroeDetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superheroe_detalle)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val superheroe: Superheroes = intent?.getSerializableExtra("superheroe") as Superheroes

        tv_nombre.text = superheroe.nombre

    }
}
