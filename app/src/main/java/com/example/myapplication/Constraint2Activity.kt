package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Constraint2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint2)
        supportActionBar?.title = "约束布局2 — 仪表盘"
    }
}
