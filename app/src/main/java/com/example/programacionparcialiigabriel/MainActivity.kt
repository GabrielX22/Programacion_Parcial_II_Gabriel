package com.example.programacionparcialiigabriel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Usa la funcion de abajo
        pasar()
    }
    fun pasar(){
        //Se le da el tiempo que se mantendra congelado y el intervalo
        object: CountDownTimer(4000,1000){
            override fun onTick(p0: Long) {
                //Aqui haria una accion cada tick, pero no la necesitamos esta vez
            }
            override fun onFinish() {
                //Cuando termine el tiempo determinado, va abrir un activity y cerrar el splashscreen
                val intento = Intent(applicationContext, MainActivity2::class.java)
                startActivity(intento)
                finish()
            }
            //Iniciar el contador
        }.start()
    }
}