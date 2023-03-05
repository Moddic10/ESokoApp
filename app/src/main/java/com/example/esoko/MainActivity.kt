package com.example.esoko

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.esoko.data.model.Product
import com.example.esoko.ui.login.LoginActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var itemEditText: EditText
    private lateinit var priceEditText: EditText
    private lateinit var displayTextView: TextView
    private var totalPrice = 0.0
    private var firestore = FirebaseFirestore.getInstance();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameEditText)
        itemEditText = findViewById(R.id.itemEditText)
        priceEditText = findViewById(R.id.priceEditText)
        displayTextView = findViewById(R.id.displayTextView)

        val buttonClick = findViewById<Button>(R.id.btnLogin);
        buttonClick.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    fun addToTotal(view: View?) {
        var product = Product(
            productName = nameEditText.text.toString(),
            productId = null,
            price = priceEditText.text.toString().toInt(),
            imageLocation = null
        );

        addItem(product);

        val name = nameEditText.text.toString()
        val item = itemEditText.text.toString()
        val priceStr = priceEditText.text.toString()
        val price = priceStr.toDouble()
        totalPrice += price

//        firestore.collection("products").
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

    /**
     * addItem - adds a product to firebase firestore
     * @param product - the product to be added to firebase
     */
    private fun addItem(product : Product){
        firestore.collection("products").add(product);
    }
}
