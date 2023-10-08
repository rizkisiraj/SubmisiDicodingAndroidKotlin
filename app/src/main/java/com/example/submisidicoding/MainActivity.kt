package com.example.submisidicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submisidicoding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Course>()
    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCourses.setHasFixedSize(true)
        list.addAll(getListHeroes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intentAbout = Intent(binding.root.context, AboutActivity::class.java)
                startActivity(intentAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListHeroes(): ArrayList<Course> {
        val dataTitle = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataSemester = resources.getStringArray(R.array.data_semester)
        val dataType = resources.getStringArray(R.array.data_type)
        val dataAuthor = resources.getStringArray(R.array.data_author)
        val listCourses = ArrayList<Course>()
        for (i in dataTitle.indices) {
            val hero = Course(dataTitle[i], dataDescription[i], dataPhoto[i], dataSemester[i], dataType[i], dataAuthor[i])
            listCourses.add(hero)
        }
        return listCourses
    }

    private fun showRecyclerList() {
        binding.rvCourses.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListCourseAdapter(list)
        binding.rvCourses.adapter = listHeroAdapter
    }
}