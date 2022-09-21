package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var wishFinal: MutableList<WishItem>
    private lateinit var wishRv: RecyclerView
    private lateinit var adapter: WishAdapter
    private lateinit var submit: Button
    private lateinit var itemName: EditText
    private lateinit var urlName: EditText
    private lateinit var priceTag: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Edit Text fields
        itemName = findViewById(R.id.itemName)
        urlName = findViewById(R.id.url)
        priceTag = findViewById(R.id.price)
        // Button
        submit = findViewById(R.id.submit)

        wishRv = findViewById(R.id.wishList)
        wishFinal = WishFetcher.sendInformation("", "",
            0.0)
        adapter = WishAdapter(wishFinal)
        wishRv.adapter = adapter
        wishRv.layoutManager = LinearLayoutManager(this)
        wishRv.visibility = View.GONE

        var click = 0

        submit.setOnClickListener {
            if (click != 0) {
                val addItem = WishFetcher.sendInformation(itemName.text.toString(), urlName.text.toString(),
                    priceTag.text.toString().toDouble())
                wishFinal.addAll(addItem)
                adapter.notifyItemChanged(wishFinal.size - addItem.size)
                wishRv.smoothScrollToPosition(wishFinal.size - addItem.size)
                itemName.text.clear()
                urlName.text.clear()
                priceTag.text.clear()
            }
            if (click == 0) {
                wishFinal[0] = WishFetcher.firstGo(itemName.text.toString(), urlName.text.toString(),
                    priceTag.text.toString().toDouble())
                adapter.notifyItemChanged(0)
                wishRv.visibility = View.VISIBLE
                itemName.text.clear()
                urlName.text.clear()
                priceTag.text.clear()
                click++
            }


        }
    }
}