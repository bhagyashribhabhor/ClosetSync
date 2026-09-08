package com.example.closetsync

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import org.json.JSONArray

class WardrobeActivity : AppCompatActivity() {

    private lateinit var wardrobeText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wardrobe)

        val btnAddClothing =
            findViewById<MaterialButton>(R.id.btnAddClothing)

        btnAddClothing.setOnClickListener {
            val intent = Intent(this, AddClothingActivity::class.java)
            startActivity(intent)
        }

        wardrobeText =
            findViewById(R.id.tvWardrobeItems)

        displayClothes()
    }

    override fun onResume() {
        super.onResume()

        if (::wardrobeText.isInitialized) {
            displayClothes()
        }
    }

    private fun displayClothes() {

        val preferences =
            getSharedPreferences("ClosetSyncWardrobe", MODE_PRIVATE)

        val savedClothes =
            preferences.getString("clothingList", "[]")

        val clothingList = JSONArray(savedClothes)

        if (clothingList.length() == 0) {

            wardrobeText.text =
                "Your wardrobe is empty 👚\n\nAdd your first clothing item to start."

            return
        }

        val result = StringBuilder()

        result.append("Your Clothes 👗\n\n")

        for (i in 0 until clothingList.length()) {

            val clothing =
                clothingList.getJSONObject(i)

            result.append("👕 ")
            result.append(clothing.getString("name"))
            result.append("\n")

            result.append("Category: ")
            result.append(clothing.getString("category"))
            result.append("\n")

            result.append("Color: ")
            result.append(clothing.getString("color"))
            result.append("\n")

            result.append("Season: ")
            result.append(clothing.getString("season"))
            result.append("\n")

            result.append("Occasion: ")
            result.append(clothing.getString("occasion"))
            result.append("\n\n")

            result.append("----------------------\n\n")
        }

        wardrobeText.text = result.toString()
    }
}