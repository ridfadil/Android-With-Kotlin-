package com.farid.dicoding.submissiononefarid.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.farid.dicoding.submissiononefarid.R
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    lateinit var tvNama: TextView
    lateinit var tvKeterangan: TextView
    lateinit var ivGambar: ImageView
    var nama = ""
    var keterangan = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout{
            ivGambar = imageView {
                setImageResource(R.drawable.img_chelsea)
            }.lparams(width = 200, height = 200){
                gravity = Gravity.CENTER
                topMargin = dip(20)
            }
            tvNama =  textView("Chelsea") {
                textSize = 29f
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
                margin = dip(20)
            }
            tvKeterangan = textView("Chelsea Merupakan Club Liga Inggris") {
                textSize = 20f
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
                margin = dip(20)
            }
        }

        //get Intent
        val i = intent
        nama = i.getStringExtra("nama")
        keterangan = i.getStringExtra("deskripsi")

        //set
        ivGambar.setImageResource(i.getIntExtra("gambar",R.drawable.img_mu))
        tvNama.text = nama
        tvKeterangan.text = keterangan

    }
}

