package com.example.saiabhinaypidugu.gymtimeticker.daggerBuilders

import com.example.saiabhinaypidugu.gymtimeticker.view.StartUpActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentActivityBuilder {

    @ContributesAndroidInjector
    abstract fun startUpActivity(): StartUpActivity

}