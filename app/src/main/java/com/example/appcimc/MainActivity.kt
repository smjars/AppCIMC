package com.example.appcimc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.RangeSlider

class MainActivity : AppCompatActivity() {

    private lateinit var hombre: CardView
    private lateinit var mujer: CardView

    private lateinit var altura:TextView
    private lateinit var slider:RangeSlider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponentes()
        initEscuchas()
    }
    private fun initComponentes() {
        hombre = findViewById(R.id.hombre)
        mujer = findViewById(R.id.mujer)
        altura = findViewById(R.id.altura)
        slider = findViewById(R.id.slider)
    }
    private fun initEscuchas(){
        hombre.setOnClickListener { seleccionar("hombre") }
        mujer.setOnClickListener { seleccionar("mujer") }
        slider.addOnChangeListener { _, value, _ ->
            val valor = value.toInt().toString()
            altura.text = "$valor cm"
        }
    }
    private fun seleccionar(sel:String) {
        if (sel == "hombre")
        {hombre.setBackgroundColor(getColor(R.color.rosaoscuro1))
         mujer.setBackgroundColor(getColor(R.color.rosaoscuro2))
        }
        else {mujer.setBackgroundColor(getColor(R.color.rosaoscuro1))
             hombre.setBackgroundColor(getColor(R.color.rosaoscuro2))
        }
    }
}