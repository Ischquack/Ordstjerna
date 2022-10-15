package com.example.ordstjerna

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNorsk.setOnClickListener {
            Intent(this, NorskActivity::class.java).also {
                startActivity(it)
            }
        }

        btnEnglish.setOnClickListener {
            Intent(this, EnglishActivity::class.java).also {
                startActivity(it)
            }
        }
    }


}