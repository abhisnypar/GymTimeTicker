package com.example.saiabhinaypidugu.gymtimeticker.utils

data class EventStatus(
        var tag: String = "tag",
        var showTimePickerDialog: Boolean = false,
        var showClockFragment: Boolean = false,
        var timeValue: String = ""
)