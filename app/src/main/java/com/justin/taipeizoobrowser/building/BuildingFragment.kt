package com.justin.taipeizoobrowser.building

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.justin.taipeizoobrowser.R
import com.justin.taipeizoobrowser.databinding.FragmentBuildingBinding
import com.justin.taipeizoobrowser.ext.getVmFactory

class BuildingFragment : Fragment() {

    private val viewModel by viewModels<BuildingViewModel> {
        getVmFactory(BuildingFragmentArgs.fromBundle(requireArguments()).building)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentBuildingBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

}