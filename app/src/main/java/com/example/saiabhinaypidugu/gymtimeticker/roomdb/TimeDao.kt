package com.example.saiabhinaypidugu.gymtimeticker.roomdb

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface TimeDao {

    @Query("SELECT * FROM timeEntity")
    fun getAll(): List<TimeEntity>

    @Query("SELECT * FROM timeEntity WHERE timerType IN (:timerType)")
    fun getTimesWithTagType(timerType: String): TimeEntity

    @Insert
    fun insertData(vararg timeEntity: TimeEntity)

    @Delete
    fun delete(timeEntity: TimeEntity)
}