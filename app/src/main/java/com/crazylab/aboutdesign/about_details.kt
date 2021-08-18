package com.crazylab.aboutdesign

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class about_details : AppCompatActivity() {
    private lateinit var Layout: ConstraintLayout
    private lateinit var quote_txt: TextView
    private lateinit var image_src: ImageView
    private lateinit var name_txt: TextView
    private lateinit var bio_txt: TextView
    private lateinit var dev_txt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_details)
        supportActionBar?.hide()

        name_txt = findViewById(R.id.name_txt)
        bio_txt = findViewById(R.id.bio_txt)
        image_src = findViewById(R.id.imageView)
        quote_txt = findViewById(R.id.quote_txt)
        dev_txt = findViewById(R.id.txt_dev)
        Layout = findViewById(R.id.constraintLayout)

        var img = intent.getIntExtra("image",R.drawable.ic_launcher_background)
        var name = intent.getStringExtra("name")
        var bio = intent.getStringExtra("work")
        var quote = intent.getStringExtra("tagline")
        val clr = intent.getIntExtra("color",Color.BLUE)

        name_txt.text = name
        bio_txt.text = bio
        quote_txt.text = quote
        image_src.setImageResource(img)
        bio_txt.setTextColor(clr)
        if (img == R.drawable.gagan)
        {
            dev_txt.text = "-Python Developer"
        }
        else
        {
            dev_txt.text = "-Android Developer"
        }
        bio_txt.isSelected = true
    }
}