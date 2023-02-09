package com.example.inclass

import android.icu.text.NumberFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class CookieAdapter(private val cookies: List<Cookie>) : RecyclerView.Adapter<CookieAdapter.CookieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CookieViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.cookie_cardview, parent, false)
    )

    override fun getItemCount() = cookies.size

    override fun onBindViewHolder(holder: CookieViewHolder, position: Int) {
        val cookie = cookies[position]
        holder.cookieImage.setImageResource(cookie.image)
        holder.cookieName.text = cookie.name
        holder.cookiePrice.text = NumberFormat.getCurrencyInstance(Locale("us")).format(cookie.price)
        holder.cookieDescription.text = cookie.description

    }

    class CookieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cookieImage: ImageView = itemView.findViewById(R.id.cookie_image)
        val cookieName: TextView = itemView.findViewById(R.id.cookie_name)
        val cookiePrice: TextView = itemView.findViewById(R.id.cookie_price)
        val cookieDescription: TextView = itemView.findViewById(R.id.cookie_description)
    }
}
