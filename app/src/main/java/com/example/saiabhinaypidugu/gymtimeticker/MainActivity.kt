package com.example.saiabhinaypidugu.gymtimeticker

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.saiabhinaypidugu.gymtimeticker.databinding.MainActivityBinding
import com.example.saiabhinaypidugu.gymtimeticker.notification.NotificationBuilder
import com.example.saiabhinaypidugu.gymtimeticker.timerDialog.CustomTimePickerDialogFragment
import com.example.saiabhinaypidugu.gymtimeticker.utils.EventStatus
import com.example.saiabhinaypidugu.gymtimeticker.view.ClockViewActivity
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.TimeTrackerViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: TimeTrackerViewModel

    @Inject
    lateinit var timePickerDialog: CustomTimePickerDialogFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val activityBinding: MainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        activityBinding.setLifecycleOwner(this)
        activityBinding.viewModel = viewModel

        viewModel.getEventState().observe(this, Observer {
            it?.let {
                handleEvent(it)
            }
        })
    }

    private fun handleEvent(eventStatus: EventStatus) {
        if (eventStatus.showTimePickerDialog) {
            showTimePickerAlertDialogFragment(eventStatus.tag)
        } else if (eventStatus.showClockFragment) {
            showClockActivity()
        }
    }

    private fun showClockActivity() {
        startActivity(Intent(this, ClockViewActivity::class.java))
    }

    private fun showTimePickerAlertDialogFragment(tag: String) {
        timePickerDialog.show(supportFragmentManager, tag)
    }
}