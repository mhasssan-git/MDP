package com.miu.sports

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.miu.sports.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sportsAdapter=PagerAdapter(this)
        binding.SportsPage.adapter=sportsAdapter
        binding.tabSports.tabGravity=TabLayout.GRAVITY_FILL
        TabLayoutMediator(binding.tabSports,binding.SportsPage){tab,position->
            when(position){
                0->{
                    tab.text="Sports"
                }
                1->{
                    tab.text="News"
                }
                2->{
                    tab.text="Athletes"
                }
                3->{
                    tab.text="Events"
                }
                4->{
                    tab.text="historical Archives"
                }
                5->{
                    tab.text="About"
                }
            }
        }.attach()

    }
}