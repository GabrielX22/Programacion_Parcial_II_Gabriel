package com.example.programacionparcialiigabriel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //Se crea el evento click del boton
        imagenviar2.setOnClickListener {
            //Se hace un IF que comprueba si estan vacios los Editext
            if(nomcliente.text.isEmpty() || nomproducto.text.isEmpty() || cantproducto.text.isEmpty()){
                //Si esta vacio, se enviara un toast que dira que llene los parametros
                Toast.makeText(this, "Llene todo los parametros", Toast.LENGTH_SHORT).show()
                }
            else{
                //De lo contrario, crearemos variables string que almacenaran lo escrito en los EditText
                var nombrecliente: String = nomcliente.text.toString()
                var nombreproducto: String = nomproducto.text.toString()
                var cantidadproducto: String = cantproducto.text.toString()
                //Se llama a la funcion con los argumentos que se necesitan
                insert2database(nombrecliente,nombreproducto,cantidadproducto)
                //Se muestra un toast de que ha sido enviado los datos
                Toast.makeText(this, "Se ha enviado el pedido con exito", Toast.LENGTH_LONG).show()
                //Se vacian los EditText ya que ya se envio la informacion
                nomcliente.setText("")
                nomproducto.setText("")
                cantproducto.setText("")
            }

        }
        //Se crea el evento click del boton de "acerca de"
        imageacerca.setOnClickListener {
            //Se limpian los EditText
            nomcliente.setText("")
            nomproducto.setText("")
            cantproducto.setText("")
            //Abre el activity de "Acerca de"
            val intent = Intent(applicationContext, MainActivity3::class.java)
            startActivity(intent)

        }
    }
    //Esta es la funcion que envia los datos a la base de datos FireBase
    fun insert2database(cliente: String, producto: String, cantidad: String) {
        val shop = HashMap<String, String>()
        //Los valores que se enviaran y como se llamaran en la base de datos
        shop["Cliente"] = cliente.toString()
        shop["Producto"] = producto.toString()
        shop["Cantidad"] = cantidad.toString()
        //Se crea la instancia a la base de datos y el nombre de la base
        val rootRef = FirebaseDatabase.getInstance().reference
        val tasksRef = rootRef.child("Tienda").push()
        tasksRef.setValue(shop)
    }
}