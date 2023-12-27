package com.example.geoquiz

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.geoquiz.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val quizViewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "Got a QuizViewModel: $quizViewModel")

        updateQuestion()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    fun trueBtnClick(view: View) {
        checkAnswer(true, view)
    }

    fun falseBtnClick(view: View) {
        checkAnswer(false, view)
    }

    fun nextBtnClick(view: View) {
        quizViewModel.moveToNext()
        updateQuestion()
    }

    fun prevBtnClick(view: View) {
        quizViewModel.moveToPrev()
        updateQuestion()
    }

    private fun updateQuestion() {
        val textResId = quizViewModel.currentQuestionText
        binding.questionTextVew.setText(textResId)
    }

    private fun checkAnswer(userAnswer: Boolean, view: View) {
        val correctAnswer = quizViewModel.currentQuestionAnswer
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