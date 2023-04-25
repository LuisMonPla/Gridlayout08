package com.example.gridlayout08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var numeros: TextView
    var cadena = ""
    var primerNumero = 0
    var operador = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numeros = findViewById(R.id.txtcalc)

    }
    fun presiono(v: View){
        val vista = v as TextView
        Log.e("Boton", "presiono $(vista.text)")

        when(vista.text) {
            "C" -> {
                cadena = ""
                numeros.text = cadena
                primerNumero = 0
                operador = ""
            }
            "+", "-" -> {
                if (cadena.isNotEmpty()) {
                    primerNumero = cadena.toInt()
                    operador = vista.text.toString()
                    cadena = ""
                }
            }
            "=" -> {
                if (cadena.isNotEmpty() && operador.isNotEmpty()) {
                    val segundoNumero = cadena.toInt()
                    var resultado = 0
                    when(operador) {
                        "+" -> resultado = primerNumero + segundoNumero
                        "-" -> resultado = primerNumero - segundoNumero
                    }
                    numeros.text = resultado.toString()
                    cadena = ""
                    operador = ""
                    primerNumero = resultado
                }
            }
            else -> {
                cadena += vista.text
                numeros.text = cadena
            }
        }
    }
    }
