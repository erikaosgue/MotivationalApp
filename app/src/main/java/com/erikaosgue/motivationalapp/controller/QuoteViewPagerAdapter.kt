package com.erikaosgue.motivationalapp.controller

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter



class QuoteViewPagerAdapter(fm: FragmentManager, var fragments: ArrayList<Fragment>)
    : FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return this.fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return this.fragments[position]
    }
}