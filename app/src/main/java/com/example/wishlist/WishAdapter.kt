package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishAdapter(private val wishItem: List<WishItem>):
    RecyclerView.Adapter<WishAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item: TextView
        var link: TextView
        var price: TextView
        init {
            item = itemView.findViewById(R.id.itemsView)
            link = itemView.findViewById(R.id.urlView)
            price = itemView.findViewById(R.id.priceView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val contractView = inflater.inflate(R.layout.wish_item, parent, false)
        // val contractView = LayoutInflator.from(parent.context).inflate(R.layout.wish_item, parent, false)
        // second way of typing it out.
        // Return a new holder instance
        return ViewHolder(contractView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wish = wishItem[position]
        holder.item.text = wish.item
        holder.price.text = wish.price.toString()
        holder.link.text = wish.link
    }

    override fun getItemCount(): Int {
        return wishItem.size
    }

}