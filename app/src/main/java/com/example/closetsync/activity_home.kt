package com.example.closetsync

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)


        val btnWardrobe = findViewById<MaterialButton>(R.id.btnWardrobe)

        btnWardrobe.setOnClickListener {
            val intent = Intent(this, WardrobeActivity::class.java)
            startActivity(intent)
        }

        val btnOutfit = findViewById<MaterialButton>(R.id.btnOutfit)

        btnOutfit.setOnClickListener {
            Toast.makeText(
                this,
                "Outfit Planner coming next!",
                Toast.LENGTH_SHORT
            ).show()
        }

        val btnHistory = findViewById<MaterialButton>(R.id.btnHistory)

        btnHistory.setOnClickListener {
            Toast.makeText(
                this,
                "Outfit History coming next!",
                Toast.LENGTH_SHORT
            ).show()
        }

        val btnMaintenance = findViewById<MaterialButton>(R.id.btnMaintenance)

        btnMaintenance.setOnClickListener {
            val intent = Intent(this, MaintenanceActivity::class.java)
            startActivity(intent)
        }

        val btnWishlist = findViewById<MaterialButton>(R.id.btnWishlist)

        btnWishlist.setOnClickListener {
            Toast.makeText(
                this,
                "Wishlist coming next!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}