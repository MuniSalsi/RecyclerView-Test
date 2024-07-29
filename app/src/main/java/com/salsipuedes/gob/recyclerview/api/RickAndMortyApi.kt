package com.salsipuedes.gob.recyclerview.api

import com.salsipuedes.gob.recyclerview.api.response.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character")
    fun getCharacters(@Query("page") page: Int): Call<CharacterResponse>
}