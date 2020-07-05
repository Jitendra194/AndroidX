package com.pills.mydemoapplication.views.hq.nav_drawer_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.pills.mydemoapplication.R

private const val VIEW_TYPE_NAV_MENU_ITEM = 4
private const val VIEW_TYPE_NAV_DIVIDER = 7

class NavigationAdapter(private val listener: NavigationAdapterListener) : ListAdapter<NavigationModelItem, NavigationViewHolder<NavigationModelItem>>(NavigationModelItem.NavigationModelItemDiff) {

    interface NavigationAdapterListener {
        fun onNavItemClicked(item: NavigationModelItem.NavMenuItem)
    }

    override fun getItemViewType(position: Int): Int = when(getItem(position)) {
        is NavigationModelItem.NavMenuItem -> VIEW_TYPE_NAV_MENU_ITEM
        is NavigationModelItem.NavDivider -> VIEW_TYPE_NAV_DIVIDER
        else -> throw RuntimeException("Unsupported ItemViewType for obj ${getItem(position)}")
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationViewHolder<NavigationModelItem> {
        return when(viewType) {
            VIEW_TYPE_NAV_MENU_ITEM ->
                NavigationViewHolder.NavMenuItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.bottom_nav_menu_item, parent, false), listener)
            VIEW_TYPE_NAV_DIVIDER ->
                NavigationViewHolder.NavDividerViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.bottom_nav_divider_item, parent, false))
            else -> throw RuntimeException("Unsupported view holder type")
        } as NavigationViewHolder<NavigationModelItem>
    }

    override fun onBindViewHolder(holder: NavigationViewHolder<NavigationModelItem>, position: Int) {
        holder.bind(getItem(position))
    }
}