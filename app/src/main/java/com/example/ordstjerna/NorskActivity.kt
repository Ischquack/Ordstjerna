package com.example.ordstjerna

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_norsk.*
import kotlin.random.Random

class NorskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_norsk)
        val spinner: Spinner = findViewById(R.id.spNedtrekk)
        val res: Resources = resources
        var buttonLetters = arrayOf<Char>('B', 'K', 'L', 'S', 'F', 'E')

        btnMidt.setText("A")
        var words: Array<String> = res.getStringArray(R.array.ord)
        var score = 0
        var index = 0
        var list = arrayListOf("Riktige ord så langt:")
        val adapter: ArrayAdapter<*> = ArrayAdapter(this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list)
        adapter.notifyDataSetChanged()
        spinner.adapter = adapter


        btnSjekk.setOnClickListener {
            val word = findViewById<EditText>(R.id.etBrukerInput).text.toString()
            val scoreCmp = score
            for (element in words) {
                if (word.equals(element, ignoreCase = true)) {
                    words[index] = ""
                    score++
                    list.add(word)
                    adapter.notifyDataSetChanged()
                    spinner.adapter = adapter
                    tvPoengsum.setText("Antall riktige: $score")
                    break
                }
                index++
            }
            index = 0
            etBrukerInput.setText("")
            if (score == scoreCmp) {
                Toast.makeText(this, "LÆR DEG NORSK!!",
                    Toast.LENGTH_LONG).show()
            }
        }

        btnBokstav1.setOnClickListener {
            val letter1 = findViewById<Button>(R.id.btnBokstav1).text.toString()
            val currentWord = findViewById<EditText>(R.id.etBrukerInput).text.toString()
            etBrukerInput.setText("$currentWord"+"$letter1")
        }

        btnBokstav2.setOnClickListener {
            val letter2 = findViewById<Button>(R.id.btnBokstav2).text.toString()
            val currentWord = findViewById<EditText>(R.id.etBrukerInput).text.toString()
            etBrukerInput.setText("$currentWord"+"$letter2")
        }
        btnBokstav3.setOnClickListener {
            val letter3 = findViewById<Button>(R.id.btnBokstav3).text.toString()
            val currentWord = findViewById<EditText>(R.id.etBrukerInput).text.toString()
            etBrukerInput.setText("$currentWord"+"$letter3")
        }
        btnMidt.setOnClickListener {
            val letterMidt = findViewById<Button>(R.id.btnMidt).text.toString()
            val currentWord = findViewById<EditText>(R.id.etBrukerInput).text.toString()
            etBrukerInput.setText("$currentWord"+"$letterMidt")
        }
        btnBokstav4.setOnClickListener {
            val letter4 = findViewById<Button>(R.id.btnBokstav4).text.toString()
            val currentWord = findViewById<EditText>(R.id.etBrukerInput).text.toString()
            etBrukerInput.setText("$currentWord"+"$letter4")
        }
        btnBokstav5.setOnClickListener {
            val letter5 = findViewById<Button>(R.id.btnBokstav5).text.toString()
            val currentWord = findViewById<EditText>(R.id.etBrukerInput).text.toString()
            etBrukerInput.setText("$currentWord"+"$letter5")
        }

        btnBokstav6.setOnClickListener {
            val letter6 = findViewById<Button>(R.id.btnBokstav6).text.toString()
            val currentWord = findViewById<EditText>(R.id.etBrukerInput).text.toString()
            etBrukerInput.setText("$currentWord"+"$letter6")
        }

        btnSlett.setOnClickListener {
            val curWord = findViewById<EditText>(R.id.etBrukerInput).text.toString()
            etBrukerInput.setText(curWord.dropLast(1))
        }

        btnOmstokk.setOnClickListener {
            buttonLetters.shuffle()
            btnBokstav1.setText(buttonLetters[0].toString())
            btnBokstav2.setText(buttonLetters[1].toString())
            btnBokstav3.setText(buttonLetters[2].toString())
            btnBokstav4.setText(buttonLetters[3].toString())
            btnBokstav5.setText(buttonLetters[4].toString())
            btnBokstav6.setText(buttonLetters[5].toString())
        }

        btnLosning.setOnClickListener {
            Intent(this, FasitActivity::class.java).also {
                it.putExtra("EXTRA_POENG", score)
                startActivity(it)
                finish()
            }
        }

        btnTips.setOnClickListener {
            val randomIndex = Random.nextInt(words.size)
            val randomWord = words[randomIndex]
            var returnWord = ""
            if (randomWord.length > 5) {
                var strippedWord = randomWord.drop(2).dropLast(2)
                returnWord = "**$strippedWord**"
            } else {
                var strippedWord = randomWord.dropLast(1).drop(1)
                returnWord = "*$strippedWord*"
            }
            tvTips.setText("$returnWord")
        }
    }


}