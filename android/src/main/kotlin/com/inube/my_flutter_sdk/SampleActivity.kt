package com.inube.my_flutter_sdk

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SampleActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val button = Button(this)
        button.text = "Close Activity"
        button.setOnClickListener {
            Toast.makeText(this, "Closing Activity", Toast.LENGTH_SHORT).show()
            finish()
        }
        setContentView(button)
    }
}
