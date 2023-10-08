package com.example.submisidicoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.submisidicoding.databinding.ActivityAboutBinding
import com.example.submisidicoding.databinding.ActivityDetailCourseBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load(getResources()
                .getIdentifier("foto", "drawable", this.getPackageName()))
            .circleCrop()
            .into(binding.imageView)

//        https://kpopping.com/documents/3e/1/Hanni-fullBodyPicture(6).webp?v=a7131
    }
}