package com.example.closetsync

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class ChatAIActivity : AppCompatActivity() {

    private lateinit var tvChat: TextView
    private lateinit var etMessage: EditText
    private lateinit var btnSend: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chat_aiactivity)

        tvChat = findViewById(R.id.tvChat)
        etMessage = findViewById(R.id.etMessage)
        btnSend = findViewById(R.id.btnSend)

        tvChat.text =
            "🤖 ClosetSync AI:\n\n" +
                    "Hi! 👋 I'm your personal fashion assistant.\n\n" +
                    "I can help you with outfits, colors, styling, and fashion ideas.\n\n" +
                    "Try asking:\n\n" +
                    "• What should I wear for college?\n\n" +
                    "• How can I style blue jeans?\n\n" +
                    "• What colors go with black?\n\n" +
                    "• What should I wear to a party?"

        btnSend.setOnClickListener {

            val message = etMessage.text.toString().trim()

            if (message.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please type a message",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            tvChat.append(
                "\n\n👤 You:\n$message"
            )

            val response = getAIResponse(message)

            tvChat.append(
                "\n\n🤖 ClosetSync AI:\n$response"
            )

            etMessage.text.clear()
        }
    }

    private fun getAIResponse(message: String): String {

        val text = message.lowercase()

        return when {

            text.contains("college") ->
                "For college, try a comfortable and stylish outfit. " +
                        "You can pair jeans with a simple top and sneakers. " +
                        "Add a small accessory to complete the look. 👗✨"

            text.contains("presentation") ->
                "For a presentation, choose a clean formal look. " +
                        "Try a solid-colored top or shirt with formal trousers " +
                        "and simple footwear."

            text.contains("jeans") ->
                "Blue jeans are very easy to style! 👖 " +
                        "Try them with a white, black, pastel, or neutral-colored top. " +
                        "Sneakers will give you a casual look."

            text.contains("black") ->
                "Black goes well with white, grey, beige, denim blue, " +
                        "and pastel colors."

            text.contains("white") ->
                "White is very versatile. 🤍 " +
                        "You can pair it with blue denim, black, pastel colors, " +
                        "or earthy tones."

            text.contains("party") ->
                "For a party, choose something stylish but comfortable. " +
                        "Try a fashionable top with well-fitted bottoms and " +
                        "matching footwear."

            text.contains("casual") ->
                "For a casual look, try jeans with a comfortable top " +
                        "and sneakers."

            text.contains("formal") ->
                "For a formal look, choose clean solid colors, " +
                        "well-fitted clothes, and simple footwear."

            text.contains("color") ->
                "Try combining one main color with a neutral color " +
                        "such as black, white, grey, beige, or denim."

            text.contains("outfit") ->
                "Sure! 👗 Tell me the occasion, such as college, party, " +
                        "presentation, wedding, or casual day."

            else ->
                "I'd love to help! 🤖✨ Tell me about the occasion, " +
                        "clothing item, color, or style you want help with."
        }
    }
}