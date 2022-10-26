package com.example.finalfm.presentation.fmgenres

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalfm.databinding.LayoutFmCategoryListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
@AndroidEntryPoint

class FmGenresFragment: Fragment() {
    private var _binding: LayoutFmCategoryListFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<GenresViewmodel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutFmCategoryListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fmCategoryAdapter = FmCategoryAdapter()
        binding.fmCategoryList.adapter = fmCategoryAdapter
        binding.fmCategoryList.layoutManager = LinearLayoutManager(requireContext())
        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiState.collectLatest{
                    when (it){
                        is UiState.Error -> Toast.makeText(
                            requireContext(), "Eror + ${it.throwable.stackTrace}",
                            Toast.LENGTH_LONG
                        ).show()
                        is UiState.Loading -> Toast.makeText(
                            requireContext(),
                            "Loading",
                            Toast.LENGTH_LONG
                        ).show()
                        is UiState.Success -> fmCategoryAdapter.updateAll(it.data.toptags.tag.map {
                            GenreUIModel(
                                it.name,
                                it.reach
                            )
                        })
                    }

                }
            }
        }
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}



