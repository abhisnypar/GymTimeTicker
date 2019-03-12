package com.example.saiabhinaypidugu.gymtimeticker.roomdb

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [TimeEntity::class], version = 1)
abstract class TimeDatabase : RoomDatabase() {
    abstract fun timeDao(): TimeDao
}