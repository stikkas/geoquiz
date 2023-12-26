package com.example.geoquiz

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.geoquiz.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentIndex: Int = 0
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateQuestion()
    }

    fun trueBtnClick(view: View) {
        checkAnswer(true, view)
    }

    fun falseBtnClick(view: View) {
        checkAnswer(false, view)
    }

    fun nextBtnClick(view: View) {
        currentIndex = (currentIndex + 1) % questionBank.size
        updateQuestion()
    }

    fun prevBtnClick(view: View) {
        currentIndex = if (currentIndex == 0) {
           questionBank.size - 1
        } else {
            (currentIndex - 1) % questionBank.size
        }
        updateQuestion()
    }

    private fun updateQuestion() {
        val textResId = questionBank[currentIndex].textResId
        binding.questionTextVew.setText(textResId)
    }

    private fun checkAnswer(userAnswer: Boolean, view: View) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Snackbar.make(view, messageResId, Snackbar.LENGTH_SHORT)
            .setTextColor(Color.YELLOW)
            .setBackgroundTint(Color.BLUE)
            .show()
    }

    fun textViewClick(view: View) {
        nextBtnClick(view)
    }

}