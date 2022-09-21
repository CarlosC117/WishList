package com.example.wishlist

class WishFetcher {

    companion object {
        fun sendInformation(i: String, l: String, p: Double): MutableList<WishItem> {
            val wishItem: MutableList<WishItem> = ArrayList()

            val wList = WishItem(i, l, p)
            wishItem.add(wList)

            return wishItem

        }

        // For the first item of the list
        fun firstGo(i: String, l: String, p: Double): WishItem {

            return WishItem(i, l, p)
        }
    }
}