package com.example.userapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var appleButton: Button
    private lateinit var orangeButton: Button
    private lateinit var bananaButton: Button
    private lateinit var tomatoButton: Button
    private lateinit var vegetableButton: Button
    private lateinit var cartButton: Button


    private lateinit var totalPriceTextView: TextView

    private var cartTotal = 0.00
    private var cartItemCount = 0
    private var totalPrice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appleButton = findViewById(R.id.appleButton)
        orangeButton = findViewById(R.id.orangeButton)
        bananaButton = findViewById(R.id.bananaButton)
        tomatoButton = findViewById(R.id.tomatoButton)
        vegetableButton = findViewById(R.id.vegetableButton)
        cartButton = findViewById(R.id.cartButton)
        totalPriceTextView = findViewById(R.id.totalPriceTextView)

        appleButton.setOnClickListener {
            cartItemCount++
            totalPrice += 15
            updateCart()
        }

        orangeButton.setOnClickListener {
            cartItemCount++
            totalPrice += 10
            updateCart()
        }

        bananaButton.setOnClickListener {
            cartItemCount++
            totalPrice += 10
            updateCart()
        }

        tomatoButton.setOnClickListener {
            cartItemCount++
            totalPrice += 5
            updateCart()
        }

        vegetableButton.setOnClickListener {
            cartItemCount++
            totalPrice += 15
            updateCart()
        }

        cartButton.setOnClickListener {
            val message = "You have $cartItemCount items in your cart.\nTotal Price: Ksh $totalPrice"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateCart() {
        cartButton.text = "Cart: $cartItemCount"
        totalPriceTextView.text = "Ksh $totalPrice"
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.appleButton -> {
                cartTotal += 0.50
                Toast.makeText(this, "Apple added to cart", Toast.LENGTH_SHORT).show()
            }
            R.id.orangeButton -> {
                cartTotal += 0.60
                Toast.makeText(this, "Orange added to cart", Toast.LENGTH_SHORT).show()
            }
            R.id.bananaButton -> {
                cartTotal += 0.25
                Toast.makeText(this, "Banana added to cart", Toast.LENGTH_SHORT).show()
            }
            R.id.tomatoButton -> {
                cartTotal += 0.75
                Toast.makeText(this, "Tomato added to cart", Toast.LENGTH_SHORT).show()
            }
            R.id.vegetableButton -> {
                cartTotal += 1.00
                Toast.makeText(this, "Vegetable added to cart", Toast.LENGTH_SHORT).show()
            }
            R.id.cartButton -> {
                Toast.makeText(this, "Cart Total: $%.2f".format(cartTotal), Toast.LENGTH_SHORT).show()
                totalPriceTextView.text = "Total Price: $%.2f".format(cartTotal)
            }
        }
    }
}
