package com.example.saiabhinaypidugu.gymtimeticker.roomdb

import android.database.Cursor
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class TimeEntryProvider(private var timeDatabase: TimeDatabase) {

    fun insertValuesToDd(timeType: String, hours: Int, minutes: Int, seconds: Int) {
        Observable.create<Void> {
            timeDatabase.timeDao().insertData(TimeEntity(timeType, hours, minutes, seconds))
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
    }

    fun queryValuesFromDb(timeType: String): Observable<TimeEntity> {
        return Observable.create<Cursor> {
            timeDatabase.timeDao().getTimesWithTagType(timeType)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { it.printStackTrace() }
                .map {
                    getTimeEntity(it, timeType)
                }
    }

    private fun getTimeEntity(cursor: Cursor?, timeType: String): TimeEntity? {
        var hours = 0
        var minutes = 0
        var seconds = 0
        cursor?.let { cursor ->
            if (cursor.moveToFirst()) {

                hours = cursor.getString(cursor.getColumnIndex("hours")) as Int
                minutes = cursor.getString(cursor.getColumnIndex("minutes")) as Int
                seconds = cursor.getString(cursor.getColumnIndex("seconds")) as Int
            }
        }

        return TimeEntity(timeType, hours, minutes, seconds)
    }
}