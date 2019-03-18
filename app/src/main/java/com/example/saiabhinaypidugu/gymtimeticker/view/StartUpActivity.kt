package com.example.saiabhinaypidugu.gymtimeticker.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.saiabhinaypidugu.gymtimeticker.GymTickerApplication
import com.example.saiabhinaypidugu.gymtimeticker.R
import com.example.saiabhinaypidugu.gymtimeticker.components.ApplicationComponent
import com.example.saiabhinaypidugu.gymtimeticker.components.DaggerFragmentComponent
import com.example.saiabhinaypidugu.gymtimeticker.databinding.ActivityStartUpBinding
import com.example.saiabhinaypidugu.gymtimeticker.modules.StartUpModule
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.StartUpViewModel
import javax.inject.Inject

class StartUpActivity : AppCompatActivity() {

    @Inject
    lateinit var startUpViewModel: StartUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFragmentComponent.builder()
                .startUpModule(StartUpModule(this)).build().inject(this)
        val startUpBinding = DataBindingUtil.setContentView<ActivityStartUpBinding>(this, R.layout.activity_start_up)
        startUpBinding.setLifecycleOwner(this)

        startUpBinding.viewModel = startUpViewModel
    }
}