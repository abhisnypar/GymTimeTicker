package com.example.saiabhinaypidugu.gymtimeticker.components

import com.example.saiabhinaypidugu.gymtimeticker.daggerBuilders.FragmentActivityBuilder
import com.example.saiabhinaypidugu.gymtimeticker.modules.StartUpModule
import com.example.saiabhinaypidugu.gymtimeticker.view.StartUpActivity
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = [
    AndroidInjectionModule::class,
    StartUpModule::class,
    FragmentActivityBuilder::class]
)
interface FragmentComponent {
    @Component.Builder
    interface Builder {
        fun startUpModule(startUpModule: StartUpModule): Builder
        fun build(): FragmentComponent
    }

    fun inject(activity: StartUpActivity)
}