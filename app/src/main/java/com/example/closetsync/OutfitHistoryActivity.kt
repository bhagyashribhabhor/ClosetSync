package com.example.closetsync

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray

class OutfitHistoryActivity : AppCompatActivity() {

    private lateinit var outfitHistoryText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_outfit_history)

        outfitHistoryText =
            findViewById(R.id.tvOutfitHistory)

        displayOutfits()
    }

    override fun onResume() {
        super.onResume()

        if (::outfitHistoryText.isInitialized) {
            displayOutfits()
        }
    }

    private fun displayOutfits() {

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

        if (outfitList.length() == 0) {

            outfitHistoryText.text =
                "No outfits saved yet 👗\n\nCreate your first outfit!"

            return
        }

        val result =
            StringBuilder()

        result.append("Your Saved Outfits 👗\n\n")

        for (i in 0 until outfitList.length()) {

            val outfit =
                outfitList.getJSONObject(i)

            result.append("👗 ")
            result.append(
                outfit.getString("outfitName")
            )
            result.append("\n\n")

            result.append("Top: ")
            result.append(
                outfit.getString("top")
            )
            result.append("\n")

            result.append("Bottom: ")
            result.append(
                outfit.getString("bottom")
            )
            result.append("\n")

            result.append("Shoes: ")
            result.append(
                outfit.getString("shoes")
            )
            result.append("\n")

            result.append("Occasion: ")
            result.append(
                outfit.getString("occasion")
            )
            result.append("\n\n")

            result.append("----------------------\n\n")
        }

        outfitHistoryText.text =
            result.toString()
    }
}