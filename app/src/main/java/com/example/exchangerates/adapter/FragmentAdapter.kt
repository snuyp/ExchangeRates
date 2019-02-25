package com.example.exchangerates.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.exchangerates.fragments.MainFragment

class FragmentAdapter(fm: FragmentManager?, context: Context?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MainFragment.newInstance()
            else -> MainFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return 1
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return when (position)
        {
            0 -> "Data"
            else -> "Not found"
        }
    }
}