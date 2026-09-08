package com.example.closetsync

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword =
            findViewById<EditText>(R.id.etConfirmPassword)

        val btnCreateAccount =
            findViewById<Button>(R.id.btnCreateAccount)

        val sharedPreferences =
            getSharedPreferences("ClosetSyncPrefs", MODE_PRIVATE)

        btnCreateAccount.setOnClickListener {

            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (name.isEmpty() ||
                email.isEmpty() ||
                password.isEmpty() ||
                confirmPassword.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            if (password != confirmPassword) {

                Toast.makeText(
                    this,
                    "Passwords do not match",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val savedEmail =
                sharedPreferences.getString("email", null)

            if (savedEmail != null &&
                savedEmail.equals(email, ignoreCase = true)
            ) {

                Toast.makeText(
                    this,
                    "Account already exists!",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            sharedPreferences.edit()
                .putString("name", name)
                .putString("email", email)
                .putString("password", password)
                .apply()

            Toast.makeText(
                this,
                "Account created successfully!",
                Toast.LENGTH_SHORT
            ).show()

            val intent =
                Intent(this, loginActivity::class.java)

            startActivity(intent)

            finish()
        }
    }
}