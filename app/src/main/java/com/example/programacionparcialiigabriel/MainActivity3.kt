package com.example.programacionparcialiigabriel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        //Se crea el evento click del boton regresar
        imageregresar.setOnClickListener {
            //Se cierra el activity
            finish()
        }
    }
}