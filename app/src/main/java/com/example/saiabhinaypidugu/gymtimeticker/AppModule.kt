package com.example.saiabhinaypidugu.gymtimeticker

import android.arch.persistence.room.Room
import android.content.Context
import android.util.AttributeSet
import com.example.saiabhinaypidugu.gymtimeticker.roomdb.TimeDatabase
import com.example.saiabhinaypidugu.gymtimeticker.roomdb.TimeEntryProvider
import com.example.saiabhinaypidugu.gymtimeticker.timeSpinner.CustomTimeSpinner
import com.example.saiabhinaypidugu.gymtimeticker.timerDialog.CustomTimePickerDialogFragment
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.TimeTrackerViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesApplication(application: GymTickerApplication): Context {
        return application
    }

    @Provides
    fun providesViewModel(context: GymTickerApplication): TimeTrackerViewModel {
        return TimeTrackerViewModel(context)
    }

    @Provides
    fun providesCustomAlertDialogFragment(): CustomTimePickerDialogFragment {
        return CustomTimePickerDialogFragment()
    }

    @Provides
    fun providesCustomSpinner(context: Context, attributeSet: AttributeSet): CustomTimeSpinner {
        return CustomTimeSpinner(context, attributeSet)
    }

    @Provides
    @Singleton
    fun providesTimeDatabase(context: GymTickerApplication): TimeDatabase {
        return Room.databaseBuilder(context, TimeDatabase::class.java, "timeDatabase").build()
    }

    @Provides
    fun providesTimeEntryProvider(timeDatabase: TimeDatabase): TimeEntryProvider {
        return TimeEntryProvider(timeDatabase)
    }
}