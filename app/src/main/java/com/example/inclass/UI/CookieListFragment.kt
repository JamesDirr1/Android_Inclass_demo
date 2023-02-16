package com.example.inclass.UI

import android.icu.text.NumberFormat
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inclass.Cookie
import com.example.inclass.CookieAdapter
import com.example.inclass.R
import java.util.*
import kotlin.random.Random


class CookieListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cookie_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.cookie_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val cookies = mutableListOf<Cookie>()

        cookies.add(
            createCookie(
                "https://www.allrecipes.com/thmb/Xv1kU5m0o0JLXMst7Kk46M0ys5Q=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/4561384-3fd7e7fa52364dafb2a36db1891b2b86.jpg",
                "Snicker-doodles",
                "A soft cookies coated in cinnamon sugar."
            )
        )
        cookies.add(
            createCookie(
                "https://www.allrecipes.com/thmb/pwmQLoLNqY-rTxTHgFrqx52KpSw=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/best-chocolate-chip-cookies-f919b3d272cf4699b8aee73e138c19c2.jpg",
                "Chocolate Chip",
                "A soft and doughy cookie filled with semi-sweet chocolate chips."
            )
        )
        cookies.add(
            createCookie(
                "https://www.allrecipes.com/thmb/9M9YfQf0EcMdQ7XBTXrCsaeo9Yw=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/Beths-Spicy-Oatmeal-Raisin-Cookies-88688de1eba24eeba29f5e07e04f064d.jpg",
                "Oatmeal Raisin",
                "Why would anyone want these when you could have chocolate chip."
            )
        )
        cookies.add(
            createCookie(
                "https://www.allrecipes.com/thmb/oREjP44_YMbn2ugZoUVMymLzGeA=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/image-1-2000-4053b8c86e0e4cc38bccc62cae35b3a0.jpg",
                "Gingersnaps",
                "A cookie that is the perfect blend of sweet and spicy."
            )
        )
        cookies.add(
            createCookie(
                "https://www.allrecipes.com/thmb/8vHeasbjazkPSkWLKqjnTKJoRa4=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/1164242-6b161580962e4e9fa11f943da6e0354b.jpg",
                "Shortbread",
                "A cookie with a lovely crumbly and tender texture."
            )
        )
        cookies.add(
            createCookie(
                "https://www.allrecipes.com/thmb/c2br4Oz6tELgoVqGKT1AZ4TCO9M=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/5473886-2000-c77ffdc505354b3190fc05a1a96f1537.jpg",
                "Peanut Butter",
                "Goes great with jelly!"
            )
        )
        cookies.add(
            createCookie(
                "https://www.allrecipes.com/thmb/1d_lwRAj82xwjJoJFI-r0pGKPME=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/3592733-25d5a72f58ec43428328da9b4230d8ff.jpg",
                "Sugar",
                "The classic cookie all know and love."
            )
        )
        cookies.add(
            createCookie(
                "https://www.allrecipes.com/thmb/OhM0NbJSMKOWC5yd5KiQg9R74LA=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/575833-a07e05e743004b5e8d5ab760ee6657ab.jpg",
                "Kiss",
                "Classic sugar cookie with a kiss chocolate pressed into the top."
            )
        )
        cookies.add(
            createCookie(
                "https://www.allrecipes.com/thmb/aKm6veAq4EgQmMmgFtc_GQpLOMw=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/5921844-51d2aa500d664119bb1df1ec67dcad1e.jpg",
                "Spritz",
                "Holiday treat that you can't miss."
            )
        )

        cookies.add(
            createCookie(
                "https://www.allrecipes.com/thmb/KLpUHDgszv7Q4d_8ZAFV7TjeBfk=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/6893087_homemade-fortune-cookies_photo-by-chef-john-9b0f1a40b85549fc9fe2b41b6ed98c3c.jpg",
                "Fortune",
                "Why not have your fortune predicted and a cookie at the same time!"
            )
        )
        cookies.add(
            createCookie(
                "https://www.allrecipes.com/thmb/AS9qyGLsMrEJIGtFJ7LrRPAwui0=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/277783-3d42f7ac94bb4bdfb5e0c635ebd0b513.jpg",
                "Gingerbread",
                "The perfect cookie to fill out you dream of eating people."
            )
        )

        val adapter = CookieAdapter(cookies)
        recyclerView.adapter = adapter

        return view
    }

    private fun createCookie(image: String, name: String, description: String) =
        Cookie(
            name = name,
            price = NumberFormat.getCurrencyInstance(Locale("us")).format(Random.nextDouble(2.00,8.00)),
            image = image,
            description = "$description Get your fresh warm $name available today!",
            stock = "Cookies in Stock: " + Random.nextInt(1, 100)
        )


}