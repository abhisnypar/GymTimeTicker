package com.example.saiabhinaypidugu.gymtimeticker.slidesPack

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.saiabhinaypidugu.gymtimeticker.view.StartUpScreenFragment
import com.example.saiabhinaypidugu.gymtimeticker.view.StartUpScreenFragmentThree
import com.example.saiabhinaypidugu.gymtimeticker.view.StartUpScreenFragmentTwo

class ScreenSlidePagerAdapter(
        fragmentManager: FragmentManager,
        private var startUpScreenFragment: StartUpScreenFragment,
        private var startUpScreenFragmentTwo: StartUpScreenFragmentTwo,
        private var startUpScreenFragmentThree: StartUpScreenFragmentThree
) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = startUpScreenFragment.newInstance(position, startUpScreenFragment)
            1 -> fragment = startUpScreenFragmentTwo.newInstance(position, startUpScreenFragmentTwo)
            2 -> fragment = startUpScreenFragmentThree.newInstance(position, startUpScreenFragmentThree)
        }
        return fragment
    }

    override fun getCount(): Int = 3
}