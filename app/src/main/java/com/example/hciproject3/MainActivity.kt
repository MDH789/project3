package com.example.hciProject3

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var numOfImages: Int = 3
    var currentImage: Int = 0
    lateinit var image : ImageView
    var places = arrayOf("The Great Wall of China", "Taj Mahal, India", "The Colosseum, Italy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)

        var placeName = findViewById<TextView>(R.id.tVName)

        val rotate = findViewById<ImageButton>(R.id.btnRotate)

        next.setOnClickListener {
            //Current image
            var idCurrentImageString = "pic$currentImage"

            //Int address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f
            image.rotation = 0f

            //Next image
            currentImage = (numOfImages+currentImage+1)%numOfImages
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            image.rotation = 0f

            //Text
            placeName.text = places[currentImage]
        }

        prev.setOnClickListener {
            //Current image
            var idCurrentImageString = "pic$currentImage"

            //Int address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f
            image.rotation = 0f

            //Previous image
            currentImage = (numOfImages+currentImage-1)%numOfImages
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            image.rotation = 0f

            //Text
            placeName.text = places[currentImage]
        }

        rotate.setOnClickListener {
            //Current image
            var idCurrentImageString = "pic$currentImage"

            //Int address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            //image.alpha = 0f
            image.rotation += 90f
        }
    }
}