package com.nuevoKT.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class nuevaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva)
        val btn_home: Button = findViewById(R.id.atras)

        val dias_seleccionados = intent.getStringArrayListExtra("dias_seleccionados")

        val selectedDaysTextView: TextView = findViewById(R.id.selected_days_text_view)

        if (dias_seleccionados != null && dias_seleccionados.isNotEmpty()) {
            selectedDaysTextView.text = "Días seleccionados: ${dias_seleccionados.joinToString(", ")}"
        }
        btn_home.setOnClickListener {
            val irHome = Intent(this, MainActivity::class.java)
            startActivity(irHome)
            finish()
        }
    }

}