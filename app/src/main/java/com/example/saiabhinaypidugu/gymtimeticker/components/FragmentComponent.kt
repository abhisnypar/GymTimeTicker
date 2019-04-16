package com.example.saiabhinaypidugu.gymtimeticker.components

import com.example.saiabhinaypidugu.gymtimeticker.modules.StartUpModule
import com.example.saiabhinaypidugu.gymtimeticker.view.StartUpActivity
import com.example.saiabhinaypidugu.gymtimeticker.view.StartUpScreenFragment
import com.example.saiabhinaypidugu.gymtimeticker.view.StartUpScreenFragmentThree
import com.example.saiabhinaypidugu.gymtimeticker.view.StartUpScreenFragmentTwo
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = [
    AndroidInjectionModule::class,
    StartUpModule::class]
)
interface FragmentComponent {
    @Component.Builder
    interface Builder {
        fun startUpModule(startUpModule: StartUpModule): Builder
        fun build(): FragmentComponent
    }

    fun inject(activity: StartUpActivity)

    fun injectFragment(fragment: StartUpScreenFragment)
    fun injectFragmentTwo(fragment: StartUpScreenFragmentTwo)
    fun injectFragmentThree(fragment: StartUpScreenFragmentThree)
}