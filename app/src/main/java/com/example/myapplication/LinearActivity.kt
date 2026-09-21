package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LinearActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear)
        supportActionBar?.title = "线性布局 — 4×4 网格"
    }
}
