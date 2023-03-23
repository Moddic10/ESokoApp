package com.example.testapp
import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var appleButton: Button
    private lateinit var orangeButton: Button
    private lateinit var bananaButton: Button
    private lateinit var tomatoButton: Button
    private lateinit var vegetableButton: Button
    private lateinit var cartButton: Button

    private lateinit var appleImageView: ImageView
    private lateinit var orangeImageView: ImageView
    private lateinit var bananaImageView: ImageView
    private lateinit var tomatoImageView: ImageView
    private lateinit var vegetableImageView: ImageView

    private lateinit var totalTextView: TextView

    private var cartItemCount = 0
    private var totalPrice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        totalTextView = findViewById(R.id.totalTextView)
        totalTextView.textSize = (24F) // set font size to 24dp
        totalTextView.typeface = Typeface.DEFAULT_BOLD// set font style to bold
        totalTextView.setTextColor(resources.getColor(R.color.white)) // set text color to white
        totalTextView.setBackgroundColor(resources.getColor(R.color.blue)) // set background color to blue

        appleButton = findViewById(R.id.appleButton)
        orangeButton = findViewById(R.id.orangeButton)
        bananaButton = findViewById(R.id.bananaButton)
        tomatoButton = findViewById(R.id.tomatoButton)
        vegetableButton = findViewById(R.id.vegetableButton)
        cartButton = findViewById(R.id.cartButton)

        appleImageView = findViewById(R.id.appleImageView)
        orangeImageView = findViewById(R.id.orangeImageView)
        bananaImageView = findViewById(R.id.bananaImageView)
        tomatoImageView = findViewById(R.id.tomatoImageView)
        vegetableImageView = findViewById(R.id.vegetableImageView)

        orangeButton.setOnClickListener {
            addToCart(12)
        }

        bananaButton.setOnClickListener {
            addToCart(10)
        }

        tomatoButton.setOnClickListener {
            addToCart(5)
        }

        vegetableButton.setOnClickListener {
            addToCart(15)
        }

        cartButton.setOnClickListener {
            displayCart()
        }

        appleImageView.setOnClickListener(this)
        orangeImageView.setOnClickListener(this)
        bananaImageView.setOnClickListener(this)
        tomatoImageView.setOnClickListener(this)
        vegetableImageView.setOnClickListener(this)

    }

    private fun addToCart(itemPrice: Int) {
        cartItemCount++
        totalPrice += itemPrice
        updateCart()
    }

    @SuppressLint("SetTextI18n")
    private fun updateCart() {
        cartButton.text = "Cart: $cartItemCount"
        totalTextView.text = "Ksh $totalPrice"
    }

    private fun displayCart() {
        val message = "You have $cartItemCount items in your cart.\nTotal Price: Ksh $totalPrice"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.appleImageView -> addToCart(10)
            R.id.orangeImageView -> addToCart(12)
            R.id.bananaImageView -> addToCart(8)
            R.id.tomatoImageView -> addToCart(5)
            R.id.vegetableImageView -> addToCart(15)
        }
    }
}
