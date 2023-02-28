package com.example.esoko

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var itemEditText: EditText
    private lateinit var priceEditText: EditText
    private lateinit var displayTextView: TextView
    private var totalPrice = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameEditText)
        itemEditText = findViewById(R.id.itemEditText)
        priceEditText = findViewById(R.id.priceEditText)
        displayTextView = findViewById(R.id.displayTextView)
    }

    fun addToTotal(view: View?) {
        val name = nameEditText.text.toString()
        val item = itemEditText.text.toString()
        val priceStr = priceEditText.text.toString()
        val price = priceStr.toDouble()
        totalPrice += price
        val displayText = """
            Name: $name
            Item: $item
            Price: ${"KSH"}$priceStr

            Total: ${"KSH"}${String.format("%.2f", totalPrice)}
        """.trimIndent()
        displayTextView.append(displayText)
        nameEditText.setText("")
        itemEditText.setText("")
        priceEditText.setText("")
    }
}
