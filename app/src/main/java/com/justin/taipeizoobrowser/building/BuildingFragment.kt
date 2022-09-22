package com.justin.taipeizoobrowser.building

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.justin.taipeizoobrowser.R

class BuildingFragment : Fragment() {

    companion object {
        fun newInstance() = BuildingFragment()
    }

    private lateinit var viewModel: BuildingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_building, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BuildingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}