package com.example.finalfm.presentation.fmgenres

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalfm.R
import com.example.finalfm.databinding.LayoutFmCategoryItemsBinding

class FmCategoryAdapter : RecyclerView.Adapter<FmCategoryAdapter.CategoryHolder>() {
    private val fmList = mutableListOf<GenreUIModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder(
            LayoutFmCategoryItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
    fun updateAll(list: List<GenreUIModel>){
        this.fmList.clear()
        this.fmList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(fmList[position])
    }

    override fun getItemCount(): Int {
        return fmList.size
    }

    inner class CategoryHolder(private val binding:LayoutFmCategoryItemsBinding) :
            RecyclerView.ViewHolder(binding.root){

    @SuppressLint("StringFormatMatches")
    fun bind(category: GenreUIModel ) {
        binding.fmCategoryName.text = category.name
        binding.fmCategoryListeners.text =
            binding.root.context.getString(R.string.fm_listeners, category.listeners)
    }
    }
}