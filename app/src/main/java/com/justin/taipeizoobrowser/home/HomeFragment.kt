package com.justin.taipeizoobrowser.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.justin.taipeizoobrowser.R
import com.justin.taipeizoobrowser.databinding.FragmentHomeBinding
import com.justin.taipeizoobrowser.ext.getVmFactory

class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel> { getVmFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.homeItems.observe(viewLifecycleOwner) {
            Log.i("Justin","HomeViewModel.homeItems = $it")
        }

        binding.recyclerviewHomeBuilding.adapter = HomeAdapter(
            HomeAdapter.OnClickListener {
                Log.i("Justin", "HomeAdapter.OnClickListener = $it")
            }
        )

        return binding.root
    }

}