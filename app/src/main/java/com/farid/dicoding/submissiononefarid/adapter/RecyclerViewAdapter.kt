package com.farid.dicoding.submissiononefarid.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.farid.dicoding.submissiononefarid.R
import com.farid.dicoding.submissiononefarid.activity.DetailActivity
import com.farid.dicoding.submissiononefarid.model.Item
import org.jetbrains.anko.intentFor

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_club, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        init{
            view.setOnClickListener {
                view.context.startActivity(view.context.intentFor<DetailActivity>())
            }
        }

        private val nama = view.findViewById<TextView>(R.id.nama_club)
        private val gambar = view.findViewById<ImageView>(R.id.gambar_club)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            nama.text = items.nama
            Glide.with(itemView.context).load(items.gambar).into(gambar)
            itemView.setOnClickListener {
                itemView.context.startActivity(itemView.context.intentFor<DetailActivity>("gambar" to items.gambar, "nama" to items.nama, "deskripsi" to items.deskripsi))
            }
        }
    }
}