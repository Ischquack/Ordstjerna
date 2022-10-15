package com.example.ordstjerna

import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_solution.*

class SolutionActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solution)

        val res: Resources = resources
        val words: Array<String> = res.getStringArray(R.array.words)
        val score = intent.getIntExtra("EXTRA_SCORE", 0)
        for (word in words) {
            val solutionList = findViewById<TextView>(R.id.AllWords).text.toString()
            AllWords.setText(solutionList + "$word \n")
        }
        FinalScore.setText("You got a final score of $score points")
    }

}