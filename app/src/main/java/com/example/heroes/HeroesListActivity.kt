package com.example.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heroes.databinding.ActivityHeroesListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeroesListActivity : AppCompatActivity() {
    companion object {
        val TAG = "HeroesListActivity"
    }

    private lateinit var binding: ActivityHeroesListBinding
    lateinit var adapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Loading questions from JSON
        val inputStream = resources.openRawResource(R.raw.heroes)
        val jsonString = inputStream.bufferedReader().use {
            // the last line of the use function is returned
            it.readText()
        }
        //file successfully read
        Log.d(TAG, "onCreate: $jsonString")

        //convert to a list of Question objects using GSON
        val gson = Gson()
        val type = object : TypeToken<List<Hero>>() { }.type
        val heroes = gson.fromJson<List<Hero>>(jsonString, type)
        Log.d(TAG, "onCreate: $heroes")

        //create adapter and fill recycler view
        adapter = HeroAdapter(heroes)
        // tell the recyclerview to use that adapter
        binding.recyclerViewHeroesList.adapter = adapter
        // tell the adapter what kind of layout we want linear or grid
        binding.recyclerViewHeroesList.layoutManager = LinearLayoutManager(this)
    }


}