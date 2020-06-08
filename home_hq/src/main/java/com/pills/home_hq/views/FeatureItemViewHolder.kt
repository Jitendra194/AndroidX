package com.pills.home_hq.views

import androidx.recyclerview.widget.RecyclerView
import com.pills.home_hq.databinding.FeatureItemBinding

class FeatureItemViewHolder(
    private val binding: FeatureItemBinding,
    private val listener: FeatureRecyclerViewAdapter.FeatureItemClickListener) : RecyclerView.ViewHolder(binding.root) {
    fun bind(featureItem: FeatureItem) = binding.run {
        item = featureItem
        clickListener = listener
        card.transitionName = featureItem.featureName.name
        executePendingBindings()
    }
}
