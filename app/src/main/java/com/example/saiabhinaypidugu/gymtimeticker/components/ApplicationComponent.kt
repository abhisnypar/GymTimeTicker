package com.example.saiabhinaypidugu.gymtimeticker.components

import com.example.saiabhinaypidugu.gymtimeticker.daggerBuilders.ActivityBuilder
import com.example.saiabhinaypidugu.gymtimeticker.GymTickerApplication
import com.example.saiabhinaypidugu.gymtimeticker.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ActivityBuilder::class,
    AndroidInjectionModule::class]
)
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: GymTickerApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: GymTickerApplication)
}