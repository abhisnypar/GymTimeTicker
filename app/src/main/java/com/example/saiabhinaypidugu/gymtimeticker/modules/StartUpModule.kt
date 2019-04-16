package com.example.saiabhinaypidugu.gymtimeticker.modules

import android.support.v4.app.FragmentActivity
import com.example.saiabhinaypidugu.gymtimeticker.slidesPack.ScreenSlidePagerAdapter
import com.example.saiabhinaypidugu.gymtimeticker.view.StartUpScreenFragment
import com.example.saiabhinaypidugu.gymtimeticker.view.StartUpScreenFragmentThree
import com.example.saiabhinaypidugu.gymtimeticker.view.StartUpScreenFragmentTwo
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.BaseModel
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.StartUpFragmentViewModel
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.StartUpViewModel
import dagger.Module
import dagger.Provides

@Module
class StartUpModule(private var fragmentActivity: FragmentActivity) {

    @Provides
    fun providesBaseModel(): BaseModel {
        return BaseModel()
    }

    @Provides
    fun providesStartUpModule(): StartUpScreenFragment {
        return StartUpScreenFragment()
    }

    @Provides
    fun providesStartUpFragmentTwo(): StartUpScreenFragmentTwo {
        return StartUpScreenFragmentTwo()
    }

    @Provides
    fun providesStartUpFragmentThree(): StartUpScreenFragmentThree {
        return StartUpScreenFragmentThree()
    }

    @Provides
    fun providesStartUpFragmentViewModel(): StartUpFragmentViewModel {
        return StartUpFragmentViewModel()
    }

    @Provides
    fun providesStartUpViewModel(screenSlidePagerAdapter: ScreenSlidePagerAdapter): StartUpViewModel {
        return StartUpViewModel(screenSlidePagerAdapter)
    }

    @Provides
    fun providesScreenSlideFragmentManager(startUpScreenFragment: StartUpScreenFragment, startUpScreenFragmentTwo: StartUpScreenFragmentTwo, startUpScreenFragmentThree: StartUpScreenFragmentThree): ScreenSlidePagerAdapter {
        return ScreenSlidePagerAdapter(fragmentActivity.supportFragmentManager, startUpScreenFragment, startUpScreenFragmentTwo, startUpScreenFragmentThree)
    }
}