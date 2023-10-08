package com.example.submisidicoding

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.submisidicoding.databinding.ActivityDetailCourseBinding

class DetailCourseActivity : AppCompatActivity() {

    companion object {
        const val COURSE = "extra_person"
    }

    private lateinit var binding: ActivityDetailCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val course = if (Build.VERSION.SDK_INT >= 33) {
                intent.getParcelableExtra<Course>(COURSE, Course::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent.getParcelableExtra<Course>(COURSE)
            }
            if (course != null) {
                binding.detailTitle.text = course.title
                binding.detailDescription.text = course.description
                binding.detailSemester.text = course.semester
                binding.detailType.text = course.type
                binding.courseAuthor.text = course.author
                Glide.with(this)
                    .load(course.photo)
                    .into(binding.detailImage)
                binding.actionShare.setOnClickListener {
                    val intentShare = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Halo, sekarang Saya sedang belajar ${course.title}!")
                        type = "text/plain"
                    }

                    val shareIntent = Intent.createChooser(intentShare, null)
                    startActivity(shareIntent)
                }
            }

    }
}