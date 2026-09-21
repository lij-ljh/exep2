package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLauncherBinding

class LauncherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLinear.setOnClickListener {
            startActivity(Intent(this, LinearActivity::class.java))
        }
        binding.btnTable.setOnClickListener {
            startActivity(Intent(this, TableActivity::class.java))
        }
        binding.btnConstraint1.setOnClickListener {
            startActivity(Intent(this, Constraint1Activity::class.java))
        }
        binding.btnConstraint2.setOnClickListener {
            startActivity(Intent(this, Constraint2Activity::class.java))
        }
        binding.btnCompose.setOnClickListener {
            startActivity(Intent(this, ComposeTaskActivity::class.java))
        }
    }
}
