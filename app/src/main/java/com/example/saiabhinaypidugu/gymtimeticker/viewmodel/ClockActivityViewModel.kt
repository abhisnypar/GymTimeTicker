package com.example.saiabhinaypidugu.gymtimeticker.viewmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.databinding.ObservableField
import android.os.CountDownTimer
import android.view.View
import com.example.saiabhinaypidugu.gymtimeticker.utils.DataProvider
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.TimeTrackerViewModel.Companion.EACH_WORKOUT_TIME

class ClockActivityViewModel(var context: Context) : ViewModel() {
    var hoursObservableField: ObservableField<String> = ObservableField()
    var minutesObservableField: ObservableField<String> = ObservableField()
    var secondsObservableField: ObservableField<String> = ObservableField()
    var hours: Int = 0
    var minutes: Int = 0
    var seconds: Int = 0
    var currentTime: Long = 0

    private var thread = Thread()

    init {
        minutes = DataProvider.getSharedPreferences(context).getInt("$EACH_WORKOUT_TIME:MINUTES", 0)
        seconds = DataProvider.getSharedPreferences(context).getInt("$EACH_WORKOUT_TIME:SECONDS", 0)


        if (currentTime > 0) {
            secondsObservableField.set(currentTime.toString())
            countDownClock(currentTime)
        } else {
            hoursObservableField.set("0")
            minutesObservableField.set("$minutes")
            secondsObservableField.set("$seconds")
        }
    }

    fun onFabClick(): View.OnClickListener {
        return View.OnClickListener {
            if (minutes > 0 || seconds > 0) {
                thread.run {
                    startClockCountDown()
                }
                thread.start()
            }
        }
    }

    private fun startClockCountDown() {
        val millisInFuture: Long = ((((minutes * 60) + (seconds)) * 1000).toLong())
        countDownClock(millisInFuture)
    }

    private fun countDownClock(millisInFuture: Long) {
        val countDownTimer = object : CountDownTimer(millisInFuture, 1000) {

            override fun onFinish() {
                thread.stop()
            }

            override fun onTick(millisUntilFinished: Long) {
                currentTime = (millisUntilFinished / 1000)
                secondsObservableField.set(currentTime.toString())
            }
        }
        countDownTimer.start()
    }
}