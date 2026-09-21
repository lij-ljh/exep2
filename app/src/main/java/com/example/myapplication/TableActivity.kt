package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
        supportActionBar?.title = "表格布局 — 菜单界面"
    }
}
