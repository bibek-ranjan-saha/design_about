package com.crazylab.aboutdesign

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.DrawableCompat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var l:LinearLayout
    lateinit var img_1:LinearLayout
    lateinit var img_2:LinearLayout
    private lateinit var exp: ConstraintLayout
    private lateinit var b1: Button
    private lateinit var v1: CardView
    private lateinit var v2: CardView
    private lateinit var v3: CardView
    var color = Color.DKGRAY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


        b1 = findViewById(R.id.btnup)
        exp = findViewById(R.id.expandableview1)
        v1 = findViewById(R.id.name_subham)
        exp = findViewById(R.id.expandableview1)
        l = findViewById(R.id.linearLayout)
        img_1 = findViewById(R.id.img_1)
        img_2 = findViewById(R.id.img_2)

        b1.setOnClickListener {
            if (exp.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(v1, AutoTransition())
                exp.visibility = View.VISIBLE
                b1.setBackgroundResource(R.drawable.up)
            } else {
                TransitionManager.beginDelayedTransition(v1, AutoTransition())
                exp.visibility = View.GONE
                b1.setBackgroundResource(R.drawable.down)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun openurl(view: View) {
        val uri = Uri.parse(view.tooltipText.toString())
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        val random = Random()
        color = Color.argb(255, random.nextInt(265), random.nextInt(265), random.nextInt(265))
        l.setBackgroundColor(color)

//        val color_1 = Color.argb(255, random.nextInt(265), random.nextInt(265), random.nextInt(265))
//        val color_2 = Color.argb(255, random.nextInt(265), random.nextInt(265), random.nextInt(265))
        var drawable_col = img_1.background
        drawable_col = DrawableCompat.wrap(drawable_col)
        drawable_col.setTint(color)
//        var drawable_col2 = img_2.background
//        drawable_col2 = DrawableCompat.wrap(drawable_col2)
//        drawable_col2.setTint(color_2)

        img_1.background = drawable_col
        img_2.background = drawable_col
    }

    fun full_view(view: View) {
        val intent = Intent(this,about_details::class.java)
        when(view.id)
        {
            R.id.subham_img ->
            {
                intent.putExtra("name","subham bikash behera")
                intent.putExtra("work","lead android developer")
                intent.putExtra("tagline","People will not see your struggles they gonna see only the Result so just work Harder.")
                intent.putExtra("image",R.drawable.subham)
            }
            R.id.bibek_img ->
            {
                intent.putExtra("name","bibek ranjan saha")
                intent.putExtra("work","I am a tech enthusiast who is keen on learning more and more,i do flutter development and android development.")
                intent.putExtra("tagline","You don't have to be perfect to do something,you have to start doing it to be master at it.")
                intent.putExtra("image",R.drawable.bibekfull)
            }
            R.id.gagn_img ->
            {
                intent.putExtra("name","gagandeep singh bhambrah")
                intent.putExtra("work","A jack-of-all-trades programmer with a flair for creating well engineered solutions. Creating, using and sharing coding gold since 2017. Efficiency-oriented python Dev since 2020.")
                intent.putExtra("tagline","Programmers are modern magician, except we transmute vague ideas into working code.")
                intent.putExtra("image",R.drawable.gagan)
            }
        }
        intent.putExtra("color",color)
        startActivity(intent)
    }
}