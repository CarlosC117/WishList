package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var wishFinal: MutableList<WishItem>
    lateinit var wishRv: RecyclerView
    lateinit var adapter: WishAdapter
    lateinit var submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wishRv= findViewById(R.id.wishList)

        submit = findViewById(R.id.submit)

        submit.setOnClickListener {
        }

    }
}