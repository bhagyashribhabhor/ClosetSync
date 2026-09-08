package com.example.closetsync

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class loginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {

            Toast.makeText(
                this,
                "Login Successful!",
                Toast.LENGTH_SHORT
            ).show()

            // Open Home Screen
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            // Close Login screen
            finish()
        }
    }
}