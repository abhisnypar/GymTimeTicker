package com.example.saiabhinaypidugu.gymtimeticker.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.saiabhinaypidugu.gymtimeticker.R
import com.example.saiabhinaypidugu.gymtimeticker.databinding.ActivityStartUpBinding
import dagger.android.AndroidInjection

class StartUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val startUpBinding = DataBindingUtil.setContentView<ActivityStartUpBinding>(this, R.layout.activity_start_up)
        startUpBinding.setLifecycleOwner(this)
    }
}