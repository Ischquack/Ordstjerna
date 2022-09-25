package com.example.ordstjerna

import android.util.Log
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_english.*
import kotlinx.android.synthetic.main.activity_main.*

 class EnglishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english)
        val spinner: Spinner = findViewById(R.id.spDropdown)
        val res: Resources = resources
        var buttonLetters = arrayOf<Char>('B', 'K', 'L', 'S', 'F', 'E')

        btnConstraint.setText("A")
        var words: Array<String> = res.getStringArray(R.array.words)
        var score = 0
        var index = 0
        var list = arrayListOf("Correct words so far")
        val adapter: ArrayAdapter<*> = ArrayAdapter(this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list)
        adapter.notifyDataSetChanged()
        spinner.adapter = adapter

        //etInput.setFilters(InputFilter[] {InputFilter.AllCaps()})


        btnCheck.setOnClickListener {
            val word = findViewById<EditText>(R.id.etInput).text.toString()
            Log.d("satan", word)
            for (element in words) {

                Log.d("fuck", element)
                if (word.equals(element, ignoreCase = true)) {
                    // add to dropdown
                    words[index] = ""
                    Log.d("knulle", element)
                    score++
                    list.add(word)
                    adapter.notifyDataSetChanged()
                    spinner.adapter = adapter
                    tvScore.setText("Current score: $score")
                    break
                }
                index++
            }
            index = 0
            etInput.setText("")
        }

        btnLetter1.setOnClickListener {
            val letter1 = findViewById<Button>(R.id.btnLetter1).text.toString()
            val currentWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText("$currentWord"+"$letter1")
        }

        btnLetter2.setOnClickListener {
            val letter2 = findViewById<Button>(R.id.btnLetter2).text.toString()
            val currentWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText("$currentWord"+"$letter2")
        }
        btnLetter3.setOnClickListener {
            val letter3 = findViewById<Button>(R.id.btnLetter3).text.toString()
            val currentWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText("$currentWord"+"$letter3")
        }
        btnLetter4.setOnClickListener {
            val letter4 = findViewById<Button>(R.id.btnLetter4).text.toString()
            val currentWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText("$currentWord"+"$letter4")
        }
        btnLetter5.setOnClickListener {
            val letter5 = findViewById<Button>(R.id.btnLetter5).text.toString()
            val currentWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText("$currentWord"+"$letter5")
        }
        btnLetter6.setOnClickListener {
            val letter6 = findViewById<Button>(R.id.btnLetter6).text.toString()
            val currentWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText("$currentWord"+"$letter6")
        }

        btnConstraint.setOnClickListener {
            val letter7 = findViewById<Button>(R.id.btnConstraint).text.toString()
            val currentWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText("$currentWord"+"$letter7")
        }

        btnDel.setOnClickListener {
            val curWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText(curWord.dropLast(1))
        }

        btnShuffle.setOnClickListener {
            buttonLetters.shuffle()
            btnLetter1.setText(buttonLetters[0].toString())
            btnLetter2.setText(buttonLetters[1].toString())
            btnLetter3.setText(buttonLetters[2].toString())
            btnLetter4.setText(buttonLetters[3].toString())
            btnLetter5.setText(buttonLetters[4].toString())
            btnLetter6.setText(buttonLetters[5].toString())
        }



    }


 }