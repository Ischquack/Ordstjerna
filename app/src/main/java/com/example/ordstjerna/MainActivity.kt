package com.example.ordstjerna

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.annotations.NonNls
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var score = 0
    var scoreText = ""
    var index = 0
    lateinit var list:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner: Spinner = findViewById(R.id.spDropdown)
        val res: Resources = resources
        val buttonLetters = arrayOf<Char>('B', 'K', 'L', 'S', 'F', 'E')

        btnConstraint.setText("A")
        val words: Array<String> = res.getStringArray(R.array.words)
        //var score = 0
        tvScore.setText(res.getString(R.string.score) + " $score")
        //var index = 0
        list = arrayListOf(res.getString(R.string.correctWords))
        val adapter: ArrayAdapter<*> = ArrayAdapter(this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list)
        adapter.notifyDataSetChanged()
        spinner.adapter = adapter

        btnCheck.setOnClickListener {
            val word = findViewById<EditText>(R.id.etInput).text.toString()
            val scoreCmp = score
            if(word.length < 4){
                Toast.makeText(this, R.string.wordTooShort,
                    Toast.LENGTH_LONG).show()
                etInput.setText("")
            }
            else if(! word.contains("A", ignoreCase = true)){
                Toast.makeText(this, R.string.missingMiddleLetter,
                    Toast.LENGTH_LONG).show()
                etInput.setText("")
            }
            else{
                for (element in words) {
                    if (word.equals(element, ignoreCase = true)) {
                        words[index] = ""
                        score++
                        list.add(word)
                        adapter.notifyDataSetChanged()
                        spinner.adapter = adapter
                        scoreText = res.getString(R.string.score)
                        tvScore.setText(scoreText + " $score")
                        Toast.makeText(this, R.string.goodFeedback,
                            Toast.LENGTH_LONG).show()
                        break
                    }
                    index++
                }
                index = 0
                etInput.setText("")
                if (score == scoreCmp) {
                    Toast.makeText(this, R.string.badFeedback,
                        Toast.LENGTH_LONG).show()
                }
            }
        }

        btnLetter1.setOnClickListener {
            val letter1 = findViewById<Button>(R.id.btnLetter1).text.toString()
            val currentWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText("$currentWord$letter1")
        }

        btnLetter2.setOnClickListener {
            val letter2 = findViewById<Button>(R.id.btnLetter2).text.toString()
            val currentWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText("$currentWord$letter2")
        }
        btnLetter3.setOnClickListener {
            val letter3 = findViewById<Button>(R.id.btnLetter3).text.toString()
            val currentWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText("$currentWord$letter3")
        }
        btnLetter4.setOnClickListener {
            val letter4 = findViewById<Button>(R.id.btnLetter4).text.toString()
            val currentWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText("$currentWord$letter4")
        }
        btnLetter5.setOnClickListener {
            val letter5 = findViewById<Button>(R.id.btnLetter5).text.toString()
            val currentWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText("$currentWord$letter5")
        }
        btnLetter6.setOnClickListener {
            val letter6 = findViewById<Button>(R.id.btnLetter6).text.toString()
            val currentWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText("$currentWord$letter6")
        }

        btnConstraint.setOnClickListener {
            val letter7 = findViewById<Button>(R.id.btnConstraint).text.toString()
            val currentWord = findViewById<EditText>(R.id.etInput).text.toString()
            etInput.setText("$currentWord$letter7")
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

        btnSolution.setOnClickListener {
            Intent(this, SolutionActivity::class.java).also {
                it.putExtra("EXTRA_SCORE", score)
                startActivity(it)
                finish()
            }
        }

        btnHint.setOnClickListener {
            val randomIndex = Random.nextInt(words.size)
            val randomWord = words[randomIndex]
            var returnWord: String
            if (randomWord.length > 5) {
                val strippedWord = randomWord.drop(2).dropLast(2)
                returnWord = "**$strippedWord**"
            } else {
                val strippedWord = randomWord.dropLast(1).drop(1)
                returnWord = "*$strippedWord*"
            }
            tvHint.setText("$returnWord")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("score", score)
        outState.putString("scoreText",scoreText)
        outState.putStringArrayList("list", list)
        Log.d("ku",list.toString())
        outState.putInt("index", index)
    }

    override fun onRestoreInstanceState(outState: Bundle){
        super.onRestoreInstanceState(outState)
        scoreText = outState.getString("scoreText").toString()
        list = outState.getStringArrayList("list") as ArrayList<String>
        Log.d("ku",list.toString())
        index = outState.getInt("index")
        score = outState.getInt("score")
        tvScore.setText(scoreText +
                " " + score)
    }
}