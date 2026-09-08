package com.example.closetsync

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import org.json.JSONArray
import org.json.JSONObject

class AddClothingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_clothing)

        val etClothingName = findViewById<EditText>(R.id.etClothingName)
        val etCategory = findViewById<EditText>(R.id.etCategory)
        val etColor = findViewById<EditText>(R.id.etColor)
        val etSeason = findViewById<EditText>(R.id.etSeason)
        val etOccasion = findViewById<EditText>(R.id.etOccasion)

        val btnSaveClothing =
            findViewById<MaterialButton>(R.id.btnSaveClothing)

        btnSaveClothing.setOnClickListener {

            val name = etClothingName.text.toString().trim()
            val category = etCategory.text.toString().trim()
            val color = etColor.text.toString().trim()
            val season = etSeason.text.toString().trim()
            val occasion = etOccasion.text.toString().trim()

            if (name.isEmpty() ||
                category.isEmpty() ||
                color.isEmpty() ||
                season.isEmpty() ||
                occasion.isEmpty()
            ) {
                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            // Get previously saved clothes
            val preferences =
                getSharedPreferences("ClosetSyncWardrobe", MODE_PRIVATE)

            val savedClothes =
                preferences.getString("clothingList", "[]")

            val clothingList = JSONArray(savedClothes)

            // Create new clothing object
            val clothing = JSONObject()

            clothing.put("name", name)
            clothing.put("category", category)
            clothing.put("color", color)
            clothing.put("season", season)
            clothing.put("occasion", occasion)

            // Add new clothing
            clothingList.put(clothing)

            // Save updated list
            preferences.edit()
                .putString("clothingList", clothingList.toString())
                .apply()

            Toast.makeText(
                this,
                "Clothing saved successfully! 👕",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}