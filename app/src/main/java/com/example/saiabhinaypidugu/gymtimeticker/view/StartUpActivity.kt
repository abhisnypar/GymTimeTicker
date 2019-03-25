package com.example.saiabhinaypidugu.gymtimeticker.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.example.saiabhinaypidugu.gymtimeticker.R
import com.example.saiabhinaypidugu.gymtimeticker.components.DaggerFragmentComponent
import com.example.saiabhinaypidugu.gymtimeticker.databinding.ActivityStartUpBinding
import com.example.saiabhinaypidugu.gymtimeticker.modules.StartUpModule
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.BaseModel
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.StartUpFragmentViewModel
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.StartUpViewModel
import javax.inject.Inject

class StartUpActivity : FragmentActivity() {

    @Inject
    lateinit var startUpViewModel: StartUpViewModel

    @Inject
    lateinit var baseModel: StartUpFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFragmentComponent.builder()
                .startUpModule(StartUpModule(this)).build().inject(this)
        super.onCreate(savedInstanceState)
        val startUpBinding = DataBindingUtil.setContentView<ActivityStartUpBinding>(this, R.layout.activity_start_up)
        startUpBinding.setLifecycleOwner(this)

        startUpBinding.viewModel = startUpViewModel
        startUpBinding.baseModel = baseModel
    }
}