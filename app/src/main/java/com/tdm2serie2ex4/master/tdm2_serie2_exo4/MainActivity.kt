package com.tdm2serie2ex4.master.tdm2_serie2_exo4

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.tdm2serie2ex4.master.tdm2_serie2_exo4.Retrofit.Ilist
import com.tdm2serie2ex4.master.tdm2_serie2_exo4.Retrofit.RetrofitClient
import com.tdm2serie2ex4.master.tdm2_serie2_exo4.Retrofit.Todos
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    internal lateinit var list: Ilist


    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        recyclerView = findViewById(R.id.recyclerview)
        recyclerAdapter = RecyclerAdapter(this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter
        val retrofit = RetrofitClient.instance
        val apiInterface = retrofit.create(Ilist::class.java ).getTodos()

     //   val apiInterface = ApiInterface.create().getMovies()

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : retrofit2.Callback<List<Todos>> {
            override fun onResponse(call: Call<List<Todos>>?, response: Response<List<Todos>>?) {

                if(response?.body() != null)
                    recyclerAdapter.setMovieListItems(response.body()!!)
               // Toast.makeText(applicationContext," succes "+ response!!.body().toString() , Toast.LENGTH_LONG).show(
               //         textView.text = response!!.body().toString();
            }

            override fun onFailure(call: Call<List<Todos>>?, t: Throwable?) {
                Toast.makeText(applicationContext," faillures " , Toast.LENGTH_LONG).show()
            }
        })







     //   val ll = Ilist.getTodos()


    }
}
