package com.example.ordstjerna

import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_losning.*

class LosningActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_losning)

        val res: Resources = resources
        val ord: Array<String> = res.getStringArray(R.array.ord)
        val poeng = intent.getIntExtra("EXTRA_POENG", 0)
        for (element in ord) {
            val losningsListe = findViewById<TextView>(R.id.tvAlleOrd).text.toString()
            tvAlleOrd.setText(losningsListe + "$element \n")
        }
        tvEndeligPoengsum.setText("You got a final score of $poeng points")
    }
}