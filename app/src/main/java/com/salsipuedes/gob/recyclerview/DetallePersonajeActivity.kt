package com.salsipuedes.gob.recyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.salsipuedes.gob.recyclerview.api.response.Personaje

class DetallePersonajeActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_detalle_personaje)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_personaje)

        // Recuperar el personaje del Intent
        val personaje = intent.getParcelableExtra<Personaje>("EXTRA_PERSONAJE")

        if (personaje != null) {
            // Encontrar las vistas
            val imagenPersonaje: ImageView = findViewById(R.id.imagen_personaje)
            val nombrePersonaje: TextView = findViewById(R.id.nombre_personaje)
            val estadoPersonaje: TextView = findViewById(R.id.estado_personaje)
            val especiePersonaje: TextView = findViewById(R.id.especie_personaje)
            val generoPersonaje: TextView = findViewById(R.id.genero_personaje)
            val origenPersonaje: TextView = findViewById(R.id.origen_personaje)

            // Actualizar las vistas con la información del personaje
            nombrePersonaje.text = personaje.name
            estadoPersonaje.text = personaje.status
            especiePersonaje.text = personaje.species
            generoPersonaje.text = personaje.gender
            origenPersonaje.text = personaje.origin.name

            // Cargar la imagen del personaje usando Glide
            Glide.with(this)
                .load(personaje.image)
                .into(imagenPersonaje)
        }
    }
}