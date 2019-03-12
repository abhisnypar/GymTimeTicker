package com.example.saiabhinaypidugu.gymtimeticker.timeSpinner

import android.content.Context
import android.databinding.DataBindingUtil
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.saiabhinaypidugu.gymtimeticker.R
import com.example.saiabhinaypidugu.gymtimeticker.databinding.TimePickerWidgetBinding
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.CustomSpinnerViewModel

class CustomTimeSpinner(context: Context, attributeSet: AttributeSet) : FrameLayout(context, attributeSet) {

    private var binding: TimePickerWidgetBinding? = null

    companion object {
        private const val MIN_ZERO = 0
        private const val MAX_HOURS = 24
        private const val MAX_SIXTY = 60
    }

    init {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.time_picker_widget, this, true)
        binding?.hours?.minValue = MIN_ZERO
        binding?.hours?.maxValue = MAX_HOURS
        binding?.minutes?.minValue = MIN_ZERO
        binding?.minutes?.maxValue = MAX_SIXTY
        binding?.seconds?.minValue = MIN_ZERO
        binding?.seconds?.maxValue = MAX_HOURS
    }

    fun setViewModel(customSpinnerViewModel: CustomSpinnerViewModel) {
        binding?.viewModel = customSpinnerViewModel
    }
}