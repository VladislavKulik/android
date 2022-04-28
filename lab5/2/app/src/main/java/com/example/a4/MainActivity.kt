package com.example.a4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a4.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val tabArray = resources.getStringArray(R.array.array_name_fragments)
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = TabAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabArray[position]
        }.attach()
    }
}