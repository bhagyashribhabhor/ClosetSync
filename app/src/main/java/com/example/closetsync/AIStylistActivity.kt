package com.example.closetsync

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class AIStylistActivity : AppCompatActivity() {

    private lateinit var ivOutfitPhoto: ImageView

    // Camera
    private val cameraLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == Activity.RESULT_OK) {

                val imageBitmap =
                    result.data?.extras?.get("data") as? Bitmap

                if (imageBitmap != null) {

                    ivOutfitPhoto.setImageBitmap(imageBitmap)

                    Toast.makeText(
                        this,
                        "Photo captured successfully 📸",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    // Gallery
    private val galleryLauncher =
        registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri ->

            if (uri != null) {

                ivOutfitPhoto.setImageURI(uri)

                Toast.makeText(
                    this,
                    "Photo selected successfully 🖼️",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_aistylist)

        // Outfit Image
        ivOutfitPhoto =
            findViewById(R.id.ivOutfitPhoto)


        // =========================
        // TAKE PHOTO
        // =========================

        val btnTakePhoto =
            findViewById<TextView>(R.id.btnTakePhoto)

        btnTakePhoto.setOnClickListener {

            val cameraIntent =
                Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            cameraLauncher.launch(cameraIntent)
        }


        // =========================
        // CHOOSE PHOTO
        // =========================

        val btnChoosePhoto =
            findViewById<TextView>(R.id.btnChoosePhoto)

        btnChoosePhoto.setOnClickListener {

            galleryLauncher.launch("image/*")
        }


        // =========================
        // CHAT WITH AI
        // =========================

        val btnChatAI =
            findViewById<TextView>(R.id.btnChatAI)

        btnChatAI.setOnClickListener {

            val intent =
                Intent(this, ChatAIActivity::class.java)

            startActivity(intent)
        }


        // =========================
        // GIVE ME AN OUTFIT
        // =========================

        val btnSuggestOutfit =
            findViewById<TextView>(R.id.btnSuggestOutfit)

        btnSuggestOutfit.setOnClickListener {

            Toast.makeText(
                this,
                "AI Outfit Suggestion coming next 🤖✨",
                Toast.LENGTH_SHORT
            ).show()
        }


        // =========================
        // STYLE THIS ITEM
        // =========================

        val btnStyleOutfit =
            findViewById<TextView>(R.id.btnStyleOutfit)

        btnStyleOutfit.setOnClickListener {

            Toast.makeText(
                this,
                "AI Style Analysis coming next 🤖👗",
                Toast.LENGTH_SHORT
            ).show()
        }


        // =========================
        // ANALYZE MY OUTFIT
        // =========================

        val btnImproveLook =
            findViewById<TextView>(R.id.btnImproveLook)

        btnImproveLook.setOnClickListener {

            Toast.makeText(
                this,
                "AI Outfit Analysis coming next 📸✨",
                Toast.LENGTH_SHORT
            ).show()
        }


        // =========================
        // STYLING IDEAS
        // =========================

        val btnStylingIdeas =
            findViewById<TextView>(R.id.btnStylingIdeas)

        btnStylingIdeas.setOnClickListener {

            Toast.makeText(
                this,
                "AI Styling Ideas coming next 💡",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}