package com.example.geoquiz

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun trueBtnClick(view: View) {
        Snackbar.make(view, R.string.correct_toast, Snackbar.LENGTH_SHORT)
            .setBackgroundTint(Color.BLUE)
            .setTextColor(Color.YELLOW)
            .show()
    }

    fun falseBtnClick(view: View) {
        Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show()
    }
}