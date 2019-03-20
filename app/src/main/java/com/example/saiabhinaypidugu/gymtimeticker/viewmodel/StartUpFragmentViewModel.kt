package com.example.saiabhinaypidugu.gymtimeticker.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean

class StartUpFragmentViewModel : ViewModel() {

    var radioOneObservableField: ObservableBoolean = ObservableBoolean(false)
    var radioTwoObservableField: ObservableBoolean = ObservableBoolean(false)
    var radioThreeObservableField: ObservableBoolean = ObservableBoolean(false)

    fun setUpRadioButtons(position: Int) {
        when (position) {
            0 -> radioOneObservableField.set(true)
            1 -> radioTwoObservableField.set(true)
            2 -> radioThreeObservableField.set(true)
        }
    }

}
