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
        // Retrieves score value from MainActivity:
        val score = intent.getIntExtra("EXTRA_SCORE", 0)

        for (word in words) {       // Print all words to allWords TextVeiw:
            val solutionList = findViewById<TextView>(R.id.AllWords).text.toString()
            AllWords.setText(solutionList + "$word \n")
        }

        FinalScore.setText(res.getString(R.string.finalScore1)
                +" $score "+res.getString(R.string.finalScore2))
    }

}