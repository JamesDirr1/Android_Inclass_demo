package com.example.inclass.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.inclass.R


class CookieDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cookie_detail, container, false)

        if (arguments != null) {
            val name = requireArguments().getString("name")
            val image = requireArguments().getString("image")
            val price = requireArguments().getString("price")
            val description = requireArguments().getString("description")
            val stock = requireArguments().getString("stock")



            Glide.with(this).load(image).into(view.findViewById(R.id.Frag_Cookie_Image))
            view.findViewById<TextView>(R.id.Frag_Cookie_Name).text = name
            view.findViewById<TextView>(R.id.Frag_Cookie_Price).text = price
            view.findViewById<TextView>(R.id.Frag_Cookie_Stock).text = stock
            view.findViewById<TextView>(R.id.Frag_Cookie_Description).text = description


        }
        return view
    }

}