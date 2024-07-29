package com.salsipuedes.gob.recyclerview.api

import com.salsipuedes.gob.recyclerview.api.response.CharacterResponse
import com.salsipuedes.gob.recyclerview.api.response.Personaje
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonajeProvider {
    companion object {
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private val api = retrofit.create(RickAndMortyApi::class.java)

        fun getCharacters(
            page: Int = 1,
            onSuccess: (List<Personaje>) -> Unit,
            onError: (Throwable) -> Unit
        ) {
            api.getCharacters(page).enqueue(object : Callback<CharacterResponse> {
                override fun onResponse(
                    call: Call<CharacterResponse>,
                    response: Response<CharacterResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { characterResponse ->
                            onSuccess(characterResponse.results)
                        }
                    } else {
                        onError(Throwable(response.message()))
                    }
                }

                override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                    onError(t)
                }
            })
        }
    }
}