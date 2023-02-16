package com.example.inclass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.inclass.UI.CookieDetailFragment

class CookieAdapter(private val cookies: List<Cookie>) :
    RecyclerView.Adapter<CookieAdapter.CookieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CookieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cookie_cardview, parent, false)
        return CookieViewHolder(view) { position ->
            val cookie = cookies[position]

            val bundle = bundleOf(
                "name" to cookie.name,
                "image" to cookie.image,
                "price" to cookie.price,
                "description" to cookie.description,
                "stock" to cookie.stock
            )

            val detailFragment = CookieDetailFragment()
            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = cookies.size

    override fun onBindViewHolder(holder: CookieViewHolder, position: Int) {
        val cookie = cookies[position]
        Glide
            .with(holder.itemView.context)
            .load(cookie.image)
            .into(holder.cookieImage)
        holder.cookieName.text = cookie.name
        holder.cookiePrice.text = cookie.price
        holder.cookieStock.text = cookie.stock

    }

    inner class CookieViewHolder(
        itemView: View,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val cookieImage: ImageView = itemView.findViewById(R.id.cookie_image)
        val cookieName: TextView = itemView.findViewById(R.id.cookie_name)
        val cookiePrice: TextView = itemView.findViewById(R.id.cookie_price)
        val cookieStock: TextView = itemView.findViewById(R.id.cookie_stock)

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }
}
