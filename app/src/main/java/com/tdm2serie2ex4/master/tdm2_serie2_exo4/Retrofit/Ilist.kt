package com.tdm2serie2ex4.master.tdm2_serie2_exo4.Retrofit

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Ilist {
    @GET("todos")
    fun getTodos ():Call<List<Todos>>

}