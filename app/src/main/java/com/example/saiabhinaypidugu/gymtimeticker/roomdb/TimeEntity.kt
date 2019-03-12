package com.example.saiabhinaypidugu.gymtimeticker.roomdb

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import io.reactivex.annotations.NonNull

@Entity
data class TimeEntity(
        @PrimaryKey
        @NonNull
        var timerType: String = "TimerType",
        @ColumnInfo(name = "hours") var hours: Int?,
        @ColumnInfo(name = "minutes") var minutes: Int?,
        @ColumnInfo(name = "seconds") var seconds: Int?
)
