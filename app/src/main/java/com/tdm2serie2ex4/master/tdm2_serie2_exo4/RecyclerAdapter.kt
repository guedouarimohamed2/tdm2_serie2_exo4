package com.tdm2serie2ex4.master.tdm2_serie2_exo4

import android.content.Context
import android.graphics.Movie
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tdm2serie2ex4.master.tdm2_serie2_exo4.Retrofit.Todos

class RecyclerAdapter(val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var movieList : List<Todos> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recylcerview_adapter,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvMovieName.text = movieList.get(position).title
        holder.userid.text = movieList.get(position).userId.toString()
        holder.id.text = movieList.get(position).id.toString()

        /*  Glide.with(context).load(movieList.get(position).userId)
                  .apply(RequestOptions().centerCrop())
                  .into(holder.image)*/
    }

    fun setMovieListItems(movieList: List<Todos>){
        this.movieList = movieList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        val tvMovieName: TextView = itemView!!.findViewById(R.id.title)

        val userid: TextView = itemView!!.findViewById(R.id.userid)

        val id: TextView = itemView!!.findViewById(R.id.id)
    //    val image: ImageView = itemView!!.findViewById(R.id.image)

    }
}