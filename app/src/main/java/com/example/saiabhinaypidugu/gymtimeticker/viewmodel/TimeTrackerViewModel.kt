package com.example.saiabhinaypidugu.gymtimeticker.viewmodel

import android.arch.lifecycle.*
import android.databinding.ObservableField
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.example.saiabhinaypidugu.gymtimeticker.GymTickerApplication
import com.example.saiabhinaypidugu.gymtimeticker.R
import com.example.saiabhinaypidugu.gymtimeticker.notification.NotificationBuilder
import com.example.saiabhinaypidugu.gymtimeticker.utils.DataProvider
import com.example.saiabhinaypidugu.gymtimeticker.utils.EventStatus

class TimeTrackerViewModel(var context: GymTickerApplication) : ViewModel() {

    var minutesObservableField: ObservableField<String> = ObservableField()
    var secondsObservableField: ObservableField<String> = ObservableField()
    var eachWorkOutTimeTextObservableField: ObservableField<String> = ObservableField()
    var intervalTimeTextObservableField: ObservableField<String> = ObservableField()
    var hours: Int = 0
    var minutes: Int = 0
    var seconds: Int = 0

    private val state = MutableLiveData<EventStatus>()
    private var totalWorkouts: Int = 0

    companion object {
        const val EACH_WORKOUT_TIME = "each_workout_time"
        const val INTERVAL_TIME = "interval_time"

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Toast.makeText(context, "On Resume Called", Toast.LENGTH_LONG).show()
    }

    fun setTotalWorkouts(newValue: CharSequence) {
        if (newValue.toString() != "" && !newValue.toString().isEmpty())
            totalWorkouts = newValue.toString().toInt()
    }

    fun onTimerClicked(): View.OnClickListener {
        return View.OnClickListener {
            when (it.id) {
                R.id.each_workout_time -> {
                    setShowTimePickerAlertDialog(EACH_WORKOUT_TIME)
                }

                R.id.interval_time -> {
                    setShowTimePickerAlertDialog(INTERVAL_TIME)
                }
            }
        }
    }

    fun startWorkouts(): View.OnClickListener {
        return View.OnClickListener {
            //            startClockFragment()
            minutes = DataProvider.getSharedPreferences(context).getInt("$EACH_WORKOUT_TIME:MINUTES", 0)
            seconds = DataProvider.getSharedPreferences(context).getInt("$EACH_WORKOUT_TIME:SECONDS", 0)
            if (minutes > 0 || seconds > 0) {
                startClockCountDown()
            }
        }
    }

    fun getEventState(): LiveData<EventStatus> {
        return state
    }

    private fun setShowTimePickerAlertDialog(tag: String) {
        state.value?.showTimePickerDialog = true
        state.value?.tag = tag
        state.postValue(EventStatus(tag, true))
    }

    private fun startClockCountDown() {
        val millisInFuture: Long = ((((minutes * 60) + (seconds)) * 1000).toLong())
        countDownClock(millisInFuture, false)
    }

    private fun countDownClock(millisInFuture: Long, intervaTime: Boolean) {
        val countDownTimer = object : CountDownTimer(millisInFuture, 1000) {

            override fun onFinish() {
                if (!intervaTime) {
                    totalWorkouts--
                    Toast.makeText(context, "Round Completed: Remaining $totalWorkouts", Toast.LENGTH_LONG).show()
                    NotificationBuilder.build(context)
                    if (totalWorkouts > 0) {
                        delayAndStartClock()
                    }
                } else {
                    Toast.makeText(context, "Interval Time Completed. Start Exercising again", Toast.LENGTH_LONG).show()
                }
            }

            override fun onTick(millisUntilFinished: Long) {
                if (!intervaTime) {
                    secondsObservableField.set((millisUntilFinished / 1000).toString())
                    DataProvider.getSharedPreferences(context).edit().putLong("INTERVAL_TIME", (millisUntilFinished / 1000)).apply()
                } else {
                    state.value?.timeValue = (millisUntilFinished / 1000).toString()
                    minutesObservableField.set((millisUntilFinished / 1000).toString())
                }
            }
        }
        countDownTimer.start()
    }

    private fun delayAndStartClock() {
        val minutesInterval = DataProvider.getSharedPreferences(context).getInt("$INTERVAL_TIME:MINUTES", 0)
        val secondsInterval = DataProvider.getSharedPreferences(context).getInt("$INTERVAL_TIME:SECONDS", 0)
        val millisInFuture: Long = ((((minutesInterval * 60) + (secondsInterval)) * 1000).toLong())
        countDownClock(millisInFuture, true)
        Handler().postDelayed({
            startClockCountDown()
        }, millisInFuture)
    }
}
