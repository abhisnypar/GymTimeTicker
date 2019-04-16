package com.example.saiabhinaypidugu.gymtimeticker.daggerBuilders

import com.example.saiabhinaypidugu.gymtimeticker.MainActivity
import com.example.saiabhinaypidugu.gymtimeticker.timerDialog.CustomTimePickerDialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun buildFragment(): CustomTimePickerDialogFragment

}