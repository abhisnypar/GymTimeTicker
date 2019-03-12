package com.example.saiabhinaypidugu.gymtimeticker

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