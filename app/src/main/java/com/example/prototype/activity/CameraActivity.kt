package com.example.prototype.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prototype.R

class CameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}