package com.example.saiabhinaypidugu.gymtimeticker.view

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saiabhinaypidugu.gymtimeticker.R
import com.example.saiabhinaypidugu.gymtimeticker.components.DaggerFragmentComponent
import com.example.saiabhinaypidugu.gymtimeticker.databinding.FragmentStartupScreenBinding
import com.example.saiabhinaypidugu.gymtimeticker.modules.StartUpModule
import com.example.saiabhinaypidugu.gymtimeticker.viewmodel.StartUpFragmentViewModel
import javax.inject.Inject

class StartUpScreenFragment : Fragment() {
    @Inject
    lateinit var screenViewModel: StartUpFragmentViewModel
    private val SCREEN_POSITION = "screen_position"

    override fun onAttach(context: Context?) {
        DaggerFragmentComponent.builder().startUpModule(StartUpModule(activity!!)).build().injectFragment(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentStartupScreenBinding>(inflater, R.layout.fragment_startup_screen, container, false)
        binding.model = screenViewModel
        arguments?.getInt(SCREEN_POSITION)?.let { screenViewModel.setUpRadioButtons(it) }
        binding.setLifecycleOwner(this)
        return binding.root
    }

    fun newInstance(position: Int, startUpScreenFragment: StartUpScreenFragment): StartUpScreenFragment {
        val bundle = Bundle()
        bundle.putInt(SCREEN_POSITION, position)
        startUpScreenFragment.arguments = bundle
        return startUpScreenFragment
    }
}