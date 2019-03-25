package com.example.saiabhinaypidugu.gymtimeticker.viewmodel

import android.databinding.ObservableField
import com.example.saiabhinaypidugu.gymtimeticker.slidesPack.ScreenSlidePagerAdapter

open class StartUpViewModel(screenSlidePagerAdapter: ScreenSlidePagerAdapter) : BaseModel() {
    var screenSlideAdapterObservableField: ObservableField<ScreenSlidePagerAdapter> = ObservableField()

    init {
        screenSlideAdapterObservableField.set(screenSlidePagerAdapter)
    }
}