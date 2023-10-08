package com.example.submisidicoding

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submisidicoding.databinding.ActivityDetailCourseBinding
import com.example.submisidicoding.databinding.ActivityMainBinding
import com.example.submisidicoding.databinding.ArticleCardBinding

class ListCourseAdapter(private var listCourses: ArrayList<Course>): RecyclerView.Adapter<ListCourseAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ArticleCardBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ArticleCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listCourses.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, photo, semester) = listCourses[position]
        holder.binding.courseTitle.text = title
        holder.binding.courseSemester.text = semester
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.courseImage)

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailCourseActivity::class.java)
            intentDetail.putExtra("extra_person", listCourses[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }

    }
}