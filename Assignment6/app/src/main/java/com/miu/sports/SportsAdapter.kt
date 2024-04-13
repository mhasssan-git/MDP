package com.miu.sports

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

class SportsAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int =4

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->SportsFragment()
            1->NewsFragment()
            2->AthlatesFragment()
            3->EventsFragment()
            4->ArchivesFragment()
            5->AboutMeFragment()
            else-> Fragment()
        }
    }
}