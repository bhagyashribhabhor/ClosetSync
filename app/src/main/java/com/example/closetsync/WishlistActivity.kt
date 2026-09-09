package com.example.closetsync

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import org.json.JSONArray
import org.json.JSONObject

class WishlistActivity : AppCompatActivity() {

    private lateinit var wishlistText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist)

        val etWishlistName =
            findViewById<EditText>(R.id.etWishlistName)

        val etWishlistCategory =
            findViewById<EditText>(R.id.etWishlistCategory)

        val etWishlistColor =
            findViewById<EditText>(R.id.etWishlistColor)

        val etWishlistOccasion =
            findViewById<EditText>(R.id.etWishlistOccasion)

        val btnSaveWishlist =
            findViewById<MaterialButton>(R.id.btnSaveWishlist)

        wishlistText =
            findViewById(R.id.tvWishlistItems)

        displayWishlist()

        btnSaveWishlist.setOnClickListener {

            val name =
                etWishlistName.text.toString().trim()

            val category =
                etWishlistCategory.text.toString().trim()

            val color =
                etWishlistColor.text.toString().trim()

            val occasion =
                etWishlistOccasion.text.toString().trim()

            if (name.isEmpty() ||
                category.isEmpty() ||
                color.isEmpty() ||
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
                    "ClosetSyncWishlist",
                    MODE_PRIVATE
                )

            val savedWishlist =
                preferences.getString(
                    "wishlistItems",
                    "[]"
                )

            val wishlist =
                JSONArray(savedWishlist)

            val item =
                JSONObject()

            item.put("name", name)
            item.put("category", category)
            item.put("color", color)
            item.put("occasion", occasion)

            wishlist.put(item)

            preferences.edit()
                .putString(
                    "wishlistItems",
                    wishlist.toString()
                )
                .apply()

            Toast.makeText(
                this,
                "Added to Wishlist ❤️",
                Toast.LENGTH_SHORT
            ).show()

            etWishlistName.text.clear()
            etWishlistCategory.text.clear()
            etWishlistColor.text.clear()
            etWishlistOccasion.text.clear()

            displayWishlist()
        }
    }

    override fun onResume() {
        super.onResume()

        if (::wishlistText.isInitialized) {
            displayWishlist()
        }
    }

    private fun displayWishlist() {

        val preferences =
            getSharedPreferences(
                "ClosetSyncWishlist",
                MODE_PRIVATE
            )

        val savedWishlist =
            preferences.getString(
                "wishlistItems",
                "[]"
            )

        val wishlist =
            JSONArray(savedWishlist)

        if (wishlist.length() == 0) {

            wishlistText.text =
                "Your wishlist is empty ❤️\n\nAdd something you want to wear!"

            return
        }

        val result =
            StringBuilder()

        result.append("Your Wishlist ❤️\n\n")

        for (i in 0 until wishlist.length()) {

            val item =
                wishlist.getJSONObject(i)

            result.append("❤️ ")
            result.append(item.getString("name"))
            result.append("\n\n")

            result.append("Category: ")
            result.append(item.getString("category"))
            result.append("\n")

            result.append("Color: ")
            result.append(item.getString("color"))
            result.append("\n")

            result.append("Occasion: ")
            result.append(item.getString("occasion"))
            result.append("\n\n")

            result.append("----------------------\n\n")
        }

        wishlistText.text =
            result.toString()
    }
}