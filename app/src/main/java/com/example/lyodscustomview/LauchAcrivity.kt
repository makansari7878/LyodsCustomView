package com.example.lyodscustomview

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class LauchAcrivity : AppCompatActivity() {
    var count = 0
    lateinit var launchViewModel: LaunchViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lauch_acrivity)
        var countButton = findViewById<Button>(R.id.buttonInc)
        var countTextview = findViewById<TextView>(R.id.textViewCount)

        launchViewModel = ViewModelProvider(this)
            .get(LaunchViewModel::class.java)
        launchViewModel.newsData.observe(this, {
            countTextview.setText("$it")
        })



       //countTextview.setText("${launchViewModel.count}")

        countButton.setOnClickListener {
//            launchViewModel.increment()
//            countTextview.setText("${launchViewModel.count}")
            launchViewModel.updateNews()

        }

    }
}