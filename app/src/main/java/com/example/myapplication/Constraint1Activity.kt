package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Constraint1Activity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private var currentInput = "0.0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint1)
        supportActionBar?.title = "约束布局1 — 计算器"

        tvDisplay = findViewById(R.id.tv_display)

        val digitButtons = listOf(
            R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4,
            R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9,
            R.id.btn_dot
        )
        for (id in digitButtons) {
            findViewById<Button>(id).setOnClickListener {
                val b = it as Button
                val d = b.text.toString()
                if (currentInput == "0.0") currentInput = ""
                currentInput += d
                tvDisplay.text = currentInput.ifEmpty { "0.0" }
            }
        }
    }
}
