package com.example.inclass



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inclass.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.character_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val cookies = mutableListOf<Cookie>()


        cookies.add(createCookie(R.drawable.snickerdoodles,"Snicker-doodles", "A soft cookies coated in cinnamon sugar."))
        cookies.add(createCookie(R.drawable.choclate_chip,"Chocolate Chip", "A soft and doughy cookie filled with semi-sweet chocolate chips."))
        cookies.add(createCookie(R.drawable.oatmeal_raisin,"Oatmeal Raisin", "Why would anyone want these when you could have chocolate chip."))
        cookies.add(createCookie(R.drawable.ginger,"Gingersnaps", "A cookie that is the perfect blend of sweet and spicy."))
        cookies.add(createCookie(R.drawable.shortbread,"Shortbread" , "A cookie with a lovely crumbly and tender texture."))
        cookies.add(createCookie(R.drawable.peanut_butter,"Peanut Butter" , "Goes great with jelly!"))
        cookies.add(createCookie(R.drawable.sugar,"Sugar", "The classic cookie all know and love."))
        cookies.add(createCookie(R.drawable.kiss,"Kiss", "Classic sugar cookie with a kiss chocolate pressed into the top."))
        cookies.add(createCookie(R.drawable.spritz,"Spritz", "Holiday treat that you can't miss."))
        cookies.add(createCookie(R.drawable.fortune,"Fortune", "Why not have your fortune predicted and a cookie at the same time!"))
        cookies.add(createCookie(R.drawable.ginger,"Gingerbread", "The perfect cookie to fill out you dream of eating people."))




        val adapter = CookieAdapter(cookies)
        recyclerView.adapter = adapter
    }

    private fun createCookie(image: Int, name: String, description: String) = Cookie(
        name = name,
        price = Random.nextDouble(3.00,8.00),
        image = image,
        description = description + " Get your fresh warm " + name + " available today!"

    )
}
