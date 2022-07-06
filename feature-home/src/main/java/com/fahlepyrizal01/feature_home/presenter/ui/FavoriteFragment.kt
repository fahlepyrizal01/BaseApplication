package com.fahlepyrizal01.feature_home.presenter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.fahlepyrizal01.core.utils.Resource
import com.fahlepyrizal01.feature_home.databinding.FragmentHomeBinding
import com.fahlepyrizal01.feature_home.presenter.adapter.GameAdapter
import com.fahlepyrizal01.feature_home.presenter.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: FavoriteViewModel by viewModels()
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
                fabLocal.isVisible = false
                rvGame.apply {
                    adapter = gameAdapter
                    layoutManager = GridLayoutManager(context, 3)
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
                                pbHome.isVisible = false
                                gameAdapter.updateGames(data)
                                rvGame.isVisible = true
                            }
                        }
                        is Resource.Error -> {
                            it.getErrorStateIfNotHandled()?.let { msg ->
                                pbHome.isVisible = false
                                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }

            viewLifecycleOwner.lifecycleScope.launch { getData() }
        }
    }

}