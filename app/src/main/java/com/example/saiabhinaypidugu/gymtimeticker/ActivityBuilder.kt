package com.example.saiabhinaypidugu.gymtimeticker

import com.example.saiabhinaypidugu.gymtimeticker.timerDialog.CustomTimePickerDialogFragment
import com.example.saiabhinaypidugu.gymtimeticker.view.StartUpActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun buildStartUpActivity(): StartUpActivity

    @ContributesAndroidInjector
    abstract fun buildFragment(): CustomTimePickerDialogFragment

}