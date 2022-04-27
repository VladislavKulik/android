package com.example.a2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.a2.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSkip.setOnClickListener {
            newGame()
        }

        newGame()
    }

    private fun newGame() {
        binding.inputUserWord.text?.clear()

        val currentWord = getWord()
        val mixed = currentWord.toCharArray().let {
            it.shuffle()
            it.concatToString()
        }
        binding.viewScrambledText.text = mixed
        binding.viewScrambledText.isAllCaps = true

        Log.d("JoperPoper", "currentWord= $currentWord")

        binding.button.setOnClickListener {
            val inputUserWord = binding.inputUserWord.text.toString() ?: ""

            if (inputUserWord.equals(currentWord, true)) {
                Toast.makeText(this, getString(R.string.toast_right), Toast.LENGTH_SHORT).show()
                newGame()
            }
            if (inputUserWord.isEmpty()) {
                Toast.makeText(this, getString(R.string.hint_enter_text), Toast.LENGTH_SHORT).show()
            }
            if (!inputUserWord.equals(currentWord, true) && inputUserWord.isNotEmpty()) {
                Toast.makeText(this, getString(R.string.toast_wrong), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getWord(): String {
        val listOfWords = resources.getStringArray(R.array.list_of_words)
        val randomWord = listOfWords[Random.nextInt(listOfWords.size)]
        val scr = randomWord.toCharArray().also {
            it.shuffle()
        }
        return randomWord
    }
}