package com.fahlepyrizal01.baseapplication.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.fahlepyrizal01.baseapplication.databinding.FragmentHomeBinding
import com.fahlepyrizal01.core.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            viewModel.data.observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {
                        pbHome.isVisible = true
                        tvTest.isVisible = false
                    }
                    is Resource.Success -> {
                        pbHome.isVisible = false
                        tvTest.apply {
                            text = it.data.toString()
                            isVisible = true
                        }
                    }
                    is Resource.Error -> {
                        pbHome.isVisible = false
                        tvTest.apply {
                            text = it.message.orEmpty()
                            isVisible = true
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getData(false)
        }
    }

}