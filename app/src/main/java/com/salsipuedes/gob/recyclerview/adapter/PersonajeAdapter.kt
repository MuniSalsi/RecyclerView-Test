package com.salsipuedes.gob.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salsipuedes.gob.recyclerview.R
import com.salsipuedes.gob.recyclerview.api.response.Personaje

class PersonajeAdapter(
    private val listado: List<Personaje>,
    private val onClickListener: (Personaje) -> Unit
) :
    RecyclerView.Adapter<PersonajeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonajeViewHolder(layoutInflater.inflate(R.layout.item_personaje, parent, false))
    }

    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        val item = listado[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = listado.size
}