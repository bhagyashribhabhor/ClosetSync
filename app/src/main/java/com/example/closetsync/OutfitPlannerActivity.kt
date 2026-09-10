package com.example.closetsync

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import org.json.JSONArray
import org.json.JSONObject

class OutfitPlannerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_outfit_planner)

        val etOutfitName =
            findViewById<EditText>(R.id.etOutfitName)

        val etTop =
            findViewById<EditText>(R.id.etTop)

        val etBottom =
            findViewById<EditText>(R.id.etBottom)

        val etShoes =
            findViewById<EditText>(R.id.etShoes)

        val etOccasion =
            findViewById<EditText>(R.id.etOccasion)

        val btnSaveOutfit =
            findViewById<MaterialButton>(R.id.btnSaveOutfit)

        btnSaveOutfit.setOnClickListener {

            val outfitName =
                etOutfitName.text.toString().trim()

            val top =
                etTop.text.toString().trim()

            val bottom =
                etBottom.text.toString().trim()

            val shoes =
                etShoes.text.toString().trim()

            val occasion =
                etOccasion.text.toString().trim()

            if (outfitName.isEmpty() ||
                top.isEmpty() ||
                bottom.isEmpty() ||
                shoes.isEmpty() ||
                occasion.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val preferences =
                getSharedPreferences(
                    "ClosetSyncOutfits",
                    MODE_PRIVATE
                )

            val savedOutfits =
                preferences.getString(
                    "outfitList",
                    "[]"
                )

            val outfitList =
                JSONArray(savedOutfits)

            val outfit =
                JSONObject()

            outfit.put(
                "outfitName",
                outfitName
            )

            outfit.put(
                "top",
                top
            )

            outfit.put(
                "bottom",
                bottom
            )

            outfit.put(
                "shoes",
                shoes
            )

            outfit.put(
                "occasion",
                occasion
            )

            outfitList.put(outfit)

            preferences.edit()
                .putString(
                    "outfitList",
                    outfitList.toString()
                )
                .apply()

            Toast.makeText(
                this,
                "Outfit saved successfully! 👗",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}