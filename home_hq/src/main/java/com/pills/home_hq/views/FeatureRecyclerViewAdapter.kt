package com.pills.home_hq.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pills.home_hq.R
import com.pills.home_hq.databinding.FeatureItemBinding

class FeatureRecyclerViewAdapter(private val featureItems: Array<FeatureItem>, private val listener: FeatureItemClickListener) : RecyclerView.Adapter<FeatureItemViewHolder>() {

    interface FeatureItemClickListener {
        fun onClickFeature(view: View, item: FeatureItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureItemViewHolder =
        DataBindingUtil.inflate<FeatureItemBinding>(LayoutInflater.from(parent.context), R.layout.feature_item, parent, false).run {
            FeatureItemViewHolder(this, listener)
        }

    override fun getItemCount(): Int = featureItems.size

    override fun onBindViewHolder(holder: FeatureItemViewHolder, position: Int) {
        holder.bind(featureItems[position])
    }
}
