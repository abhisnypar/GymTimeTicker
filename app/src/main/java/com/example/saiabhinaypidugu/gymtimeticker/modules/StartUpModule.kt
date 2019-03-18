package com.example.saiabhinaypidugu.gymtimeticker.modules

import android.support.v4.app.FragmentActivity
import com.example.saiabhinaypidugu.gymtimeticker.slidesPack.ScreenSlidePagerAdapter
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.StartUpViewModel
import dagger.Module
import dagger.Provides

@Module
class StartUpModule(private var fragmentActivity: FragmentActivity) {

    @Provides
    fun providesStartUpViewModel(screenSlidePagerAdapter: ScreenSlidePagerAdapter): StartUpViewModel {
        return StartUpViewModel(screenSlidePagerAdapter)
    }

    @Provides
    fun providesScreenSlideFragmentManager(): ScreenSlidePagerAdapter {
        return ScreenSlidePagerAdapter(fragmentActivity.supportFragmentManager)
    }
}