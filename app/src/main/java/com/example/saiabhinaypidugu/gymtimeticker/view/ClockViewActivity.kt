package com.example.saiabhinaypidugu.gymtimeticker.view

import android.arch.lifecycle.LifecycleObserver
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.saiabhinaypidugu.gymtimeticker.R
import com.example.saiabhinaypidugu.gymtimeticker.databinding.ActivityClockViewBinding

class ClockViewActivity : AppCompatActivity(), LifecycleObserver {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val databinding: ActivityClockViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_clock_view)
        databinding.setLifecycleOwner(this)
    }
}