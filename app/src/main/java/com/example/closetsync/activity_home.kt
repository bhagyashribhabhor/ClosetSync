package com.example.closetsync

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnWardrobe =
            findViewById<TextView>(R.id.btnWardrobe)

        btnWardrobe.setOnClickListener {
            startActivity(
                Intent(this, WardrobeActivity::class.java)
            )
        }

        val btnOutfit =
            findViewById<TextView>(R.id.btnOutfit)

        btnOutfit.setOnClickListener {
            startActivity(
                Intent(this, OutfitPlannerActivity::class.java)
            )
        }

        val btnHistory =
            findViewById<TextView>(R.id.btnHistory)

        btnHistory.setOnClickListener {
            startActivity(
                Intent(this, OutfitHistoryActivity::class.java)
            )
        }

        val btnMaintenance =
            findViewById<TextView>(R.id.btnMaintenance)

        btnMaintenance.setOnClickListener {
            startActivity(
                Intent(this, MaintenanceActivity::class.java)
            )
        }

        val btnWishlist =
            findViewById<TextView>(R.id.btnWishlist)

        btnWishlist.setOnClickListener {
            startActivity(
                Intent(this, WishlistActivity::class.java)
            )
        }

        val btnAIStylist =
            findViewById<TextView>(R.id.btnAIStylist)

        btnAIStylist.setOnClickListener {
            startActivity(
                Intent(this, AIStylistActivity::class.java)
            )
        }
    }
}