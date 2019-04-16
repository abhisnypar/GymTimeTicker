package com.example.saiabhinaypidugu.gymtimeticker.timerDialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import com.example.saiabhinaypidugu.gymtimeticker.R
import com.example.saiabhinaypidugu.gymtimeticker.databinding.TimePickerAlertDialogBinding
import com.example.saiabhinaypidugu.gymtimeticker.roomdb.TimeEntryProvider
import com.example.saiabhinaypidugu.gymtimeticker.utils.DataProvider
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.CustomSpinnerViewModel
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.HoursValue
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.MinutesValue
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.SecondsValue
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.TimeTrackerViewModel.Companion.EACH_WORKOUT_TIME
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.TimeTrackerViewModel.Companion.INTERVAL_TIME
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CustomTimePickerDialogFragment : DialogFragment() {

    @Inject
    lateinit var timeEntryProvider: TimeEntryProvider

    private var customSpinnerViewModel: CustomSpinnerViewModel = CustomSpinnerViewModel()

    private var hours: Int = 0
    private var minutes: Int = 0
    private var seconds: Int = 0

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        customSpinnerViewModel.getHoursLiveData().observeForever { it ->
            it?.let {
                handleHours(it)
            }
        }
        customSpinnerViewModel.getMinutesLiveData().observeForever {it ->
            it?.let {
                handleMinutes(it)
            }
        }
        customSpinnerViewModel.getSecondsLiveData().observeForever { it ->
            it?.let {
                handSeconds(it)
            }
        }
    }

    private fun handSeconds(it: SecondsValue?) {
        it?.let {
            this.seconds = it.Seconds
        }
    }

    private fun handleMinutes(it: MinutesValue?) {
        it?.let {
            this.minutes = it.minutes
        }
    }

    private fun handleHours(it: HoursValue?) {
        it?.apply {
            this.hours = it.hours
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialog = AlertDialog.Builder(context)
        val binding: TimePickerAlertDialogBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.time_picker_alert_dialog, null, false
        )
        binding.setLifecycleOwner(this)
        binding.viewModel = customSpinnerViewModel
        alertDialog.setView(binding.root)
        alertDialog.setTitle("Select the Time")
        alertDialog.setPositiveButton("OK") { dialogInterface, _ ->
            insertValuesToDb(tag)
            dialogInterface.dismiss()
        }
        alertDialog.setNegativeButton("Cancel") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }

        return alertDialog.create()
    }

    override fun onResume() {
        super.onResume()
        dialog?.setCancelable(false)
    }

    private fun insertValuesToDb(timeType: String?) {
        when (timeType) {
            EACH_WORKOUT_TIME -> {
                insertData(EACH_WORKOUT_TIME)
            }
            INTERVAL_TIME -> {
                insertData(INTERVAL_TIME)
            }
        }
    }

    private fun insertData(timeType: String) {
        context?.let {
            DataProvider.saveHoursData(it, hours, timeType)
            DataProvider.saveMinutesData(it, minutes, timeType)
            DataProvider.saveSecondsData(it, seconds, timeType)
        }
        timeEntryProvider.insertValuesToDd(timeType, hours, minutes, seconds)
    }
}
