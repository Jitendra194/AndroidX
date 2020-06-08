package com.pills.mydemoapplication.views.hq.nav_drawer_adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pills.mydemoapplication.databinding.BottomNavDividerItemBinding
import com.pills.mydemoapplication.databinding.BottomNavMenuItemBinding

sealed class NavigationViewHolder<T: NavigationModelItem>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(navItem : T)

    class NavMenuItemViewHolder(private val binding: BottomNavMenuItemBinding,
                                private val listener: NavigationAdapter.NavigationAdapterListener) : NavigationViewHolder<NavigationModelItem.NavMenuItem>(binding.root) {
        override fun bind(navItem: NavigationModelItem.NavMenuItem) {
            binding.run {
                item = navItem
                itemClick = listener
                executePendingBindings()
            }
        }
    }

    class NavDividerViewHolder(private val binding: BottomNavDividerItemBinding) : NavigationViewHolder<NavigationModelItem.NavDivider>(binding.root) {
        override fun bind(navItem: NavigationModelItem.NavDivider) {
            binding.run {
                if (navItem.title != null) {
                    divider = navItem
                } else {
                    binding.dividerSubtitle.visibility = View.GONE
                }
                executePendingBindings()
            }
        }
    }
}