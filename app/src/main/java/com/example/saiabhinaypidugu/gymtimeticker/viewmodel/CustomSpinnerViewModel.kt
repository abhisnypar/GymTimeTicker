package com.example.saiabhinaypidugu.gymtimeticker.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class CustomSpinnerViewModel : ViewModel() {

    private val entityHoursLiveData = MutableLiveData<HoursValue>()
    private val entityMinutesLiveData = MutableLiveData<MinutesValue>()
    private val entitySecondsLiveData = MutableLiveData<SecondsValue>()

    fun getHoursLiveData(): LiveData<HoursValue> {
        return entityHoursLiveData
    }

    fun getMinutesLiveData(): LiveData<MinutesValue> {
        return entityMinutesLiveData
    }

    fun getSecondsLiveData(): LiveData<SecondsValue> {
        return entitySecondsLiveData
    }

    fun onHoursChange(oldv: Int, newv: Int) {
        entityHoursLiveData.value?.hours = newv
        entityHoursLiveData.postValue(HoursValue(newv))
    }

    fun onMinutesChange(oldv: Int, newv: Int) {
        entityMinutesLiveData.value?.minutes = newv
        entityMinutesLiveData.postValue(MinutesValue(newv))
    }

    fun onSecondsChange(oldv: Int, newv: Int) {
        entitySecondsLiveData.value?.Seconds = newv
        entitySecondsLiveData.postValue(SecondsValue(newv))
    }
}

data class HoursValue(var hours: Int)
data class MinutesValue(var minutes: Int)
data class SecondsValue(var Seconds: Int)
