package com.salsipuedes.gob.recyclerview.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.salsipuedes.gob.recyclerview.api.response.Personaje
import com.salsipuedes.gob.recyclerview.databinding.ItemPersonajeBinding

// Con View Binding:
class PersonajeViewHolder(view: View) : ViewHolder(view) {
    val binding = ItemPersonajeBinding.bind(view)

    fun render(personaje: Personaje, onClickListener: (Personaje) -> Unit) {
        binding.nombrePersonaje.text = personaje.name
        binding.estadoPersonaje.text = personaje.status
        binding.especiePersonaje.text = personaje.species
        binding.generoPersonaje.text = personaje.gender
        binding.origenPersonaje.text = personaje.origin.name
        Glide.with(binding.imagenPersonaje.context).load(personaje.image)
            .into(binding.imagenPersonaje)

        // Usando la funcion lambda:
        binding.btnDeatail.setOnClickListener {
            onClickListener(personaje)
        }

        // Sin usar la funcion lambda:
//        binding.btnDeatail.setOnClickListener {
//            Toast.makeText(
//                binding.imagenPersonaje.context,
//                "Se hizo click en el detalle.",
//                Toast.LENGTH_LONG
//            ).show()
//        }
    }
}

// Sin View Binding:
//class PersonajeViewHolder(view: View) : ViewHolder(view) {
//
//    val imagen = view.findViewById<ImageView>(R.id.imagen_personaje)
//    val nombre = view.findViewById<TextView>(R.id.nombre_personaje)
//    val estado = view.findViewById<TextView>(R.id.estado_personaje)
//    val especie = view.findViewById<TextView>(R.id.especie_personaje)
//    val genero = view.findViewById<TextView>(R.id.genero_personaje)
//    val origen = view.findViewById<TextView>(R.id.origen_personaje)
//
//    fun render(personaje: Personaje) {
//        nombre.text = personaje.name
//        estado.text = "Estado: ${personaje.status}"
//        especie.text = "Especie: ${personaje.species}"
//        genero.text = "Género: ${personaje.gender}"
//        origen.text = "Origen: ${personaje.origin.name}"
//        Glide.with(imagen.context).load(personaje.image).into(imagen)
//    }
//}