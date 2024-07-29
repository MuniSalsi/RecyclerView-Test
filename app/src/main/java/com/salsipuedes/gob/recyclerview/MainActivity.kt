package com.salsipuedes.gob.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.salsipuedes.gob.recyclerview.adapter.PersonajeAdapter
import com.salsipuedes.gob.recyclerview.api.PersonajeProvider
import com.salsipuedes.gob.recyclerview.api.response.Personaje
import com.salsipuedes.gob.recyclerview.databinding.ActivityMainBinding

// Con View Bindign:
class MainActivity : AppCompatActivity() {
    private lateinit var recycler: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniciarRecyclerView()
    }

    private fun iniciarRecyclerView() {
        val manager = LinearLayoutManager(this)

        // Agregando un divier item:
        val decoration = DividerItemDecoration(this, manager.orientation)

        binding.listadoPersonajes.layoutManager = manager

        PersonajeProvider.getCharacters(
            page = 1,
            onSuccess = { personajes ->
                // Manejar la lista de personajes aquí
                binding.listadoPersonajes.adapter = PersonajeAdapter(
                    personajes
                ) { personaje -> onItemSelected(personaje) }

                binding.listadoPersonajes.addItemDecoration(decoration)
            },
            onError = { error ->
                // Manejar el error aquí
                Log.e("Error", error.message ?: "Error desconocido")
            }
        )
    }

    private fun onItemSelected(personaje: Personaje) {
        Log.d("PERSONAJE", "$personaje")
        val intent = Intent(this, DetallePersonajeActivity::class.java)
        intent.putExtra("EXTRA_PERSONAJE", personaje)
        startActivity(intent)
    }
}

// Sin View Bindign:

//class MainActivity : AppCompatActivity() {
//    private lateinit var recycler: RecyclerView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//
//        iniciarRecyclerView()
//
//
//    }
//
//    private fun iniciarRecyclerView() {
//        recycler = findViewById(R.id.listadoPersonajes)
//        recycler.layoutManager = LinearLayoutManager(this)
//
//        PersonajeProvider.getCharacters(
//            page = 1,
//            onSuccess = { personajes ->
//                // Manejar la lista de personajes aquí
//                recycler.adapter = PersonajeAdapter(personajes)
//
//            },
//            onError = { error ->
//                // Manejar el error aquí
//                Log.e("Error", error.message ?: "Error desconocido")
//            }
//        )
//    }
//}
