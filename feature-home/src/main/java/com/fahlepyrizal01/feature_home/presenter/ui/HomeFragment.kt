package com.fahlepyrizal01.feature_home.presenter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.fahlepyrizal01.core.utils.Resource
import com.fahlepyrizal01.feature_home.databinding.FragmentHomeBinding
import com.fahlepyrizal01.feature_home.presenter.adapter.GameAdapter
import com.fahlepyrizal01.feature_home.presenter.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val gameAdapter by lazy { GameAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            with(binding) {
                rvGame.apply {
                    adapter = gameAdapter
                    layoutManager = GridLayoutManager(context, 3)
                }

                fabLocal.setOnClickListener {
                    findNavController().navigate(HomeFragmentDirections.actionHomeToFavorite())
                }

                games.observe(viewLifecycleOwner) {
                    when (it) {
                        is Resource.Loading -> {
                            it.getLoadingStateIfNotHandled()?.let {
                                pbHome.isVisible = true
                                rvGame.isVisible = false
                            }
                        }
                        is Resource.Success -> {
                            it.getSuccessStateIfNotHandled()?.let { data ->
                                viewLifecycleOwner.lifecycleScope.launch {setData(data) }
                                pbHome.isVisible = false
                                gameAdapter.updateGames(data)
                                rvGame.isVisible = true
                            }
                        }
                        is Resource.Error -> {
                            it.getErrorStateIfNotHandled()?.let { msg ->
                                pbHome.isVisible = false
                                Toast.makeText(context, msg, LENGTH_SHORT).show()
                            }
                        }
                    }
                }

                result.observe(viewLifecycleOwner) {
                    when (it) {
                        is Resource.Loading -> Unit
                        is Resource.Success -> {
                            it.getSuccessStateIfNotHandled()?.let { data ->
                                Toast.makeText(
                                    context, "Success Save Local = $data", LENGTH_SHORT
                                ).show()
                            }
                        }
                        is Resource.Error -> {
                            it.getErrorStateIfNotHandled()?.let { msg ->
                                Toast.makeText(
                                    context, msg, LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            }

            viewLifecycleOwner.lifecycleScope.launch { getData() }
        }
    }

}