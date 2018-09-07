package com.farid.dicoding.submissiononefarid.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.farid.dicoding.submissiononefarid.R
import com.farid.dicoding.submissiononefarid.adapter.RecyclerViewAdapter
import com.farid.dicoding.submissiononefarid.model.Item
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), AnkoLogger {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialized()

        //Kotlin Android Extension
        rv_club.layoutManager = LinearLayoutManager(this)
        rv_club.adapter = RecyclerViewAdapter(this, items) {
            toast("Anda Sudah Memilih Detail ${it.nama}  ")
            startActivity(intentFor<DetailActivity>("isSuccess" to true).clearTask())
        }
    }

    private fun initialized() {
        val nama = resources.getStringArray(R.array.nama_klub)
        val gambar = resources.obtainTypedArray(R.array.gambar_klub)
        val deskripsi = resources.getStringArray(R.array.deskripsi_klub)
        items.clear()
        for (i in nama.indices) {
            items.add(Item(nama[i], gambar.getResourceId(i, 0),deskripsi[i]))
        }
        gambar.recycle()
    }
}