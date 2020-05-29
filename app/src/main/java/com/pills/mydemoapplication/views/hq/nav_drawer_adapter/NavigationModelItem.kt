package com.pills.mydemoapplication.views.hq.nav_drawer_adapter

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.DiffUtil

sealed class NavigationModelItem {
    companion object {
        const val HOME: Int = 0
        const val EDIT_PROFILE: Int = 1
        const val PAYMENT_METHOD: Int = 2
        const val FEEDBACK: Int = 3
        const val HELP: Int = 4
    }
    data class NavMenuItem(val id: Int, @DrawableRes val icon: Int, @StringRes val titleRes: Int, val checked: Boolean) : NavigationModelItem()
    data class NavSignOutItem(val id: Int, @DrawableRes val icon: Int, @StringRes val titleRes: Int) : NavigationModelItem()
    data class NavDivider(val title: String?) : NavigationModelItem()

    object NavigationModelItemDiff : DiffUtil.ItemCallback<NavigationModelItem>() {
        override fun areItemsTheSame(oldItem: NavigationModelItem, newItem: NavigationModelItem): Boolean {
            return when {
                oldItem is NavMenuItem && newItem is NavMenuItem -> oldItem.id == newItem.id
                oldItem is NavSignOutItem && newItem is NavSignOutItem -> oldItem.id == newItem.id
                else -> oldItem == newItem
            }
        }

        override fun areContentsTheSame(oldItem: NavigationModelItem, newItem: NavigationModelItem): Boolean {
            return when {
                oldItem is NavMenuItem && newItem is NavMenuItem ->
                    oldItem.icon == newItem.icon && oldItem.titleRes == newItem.titleRes && oldItem.checked == newItem.checked
                oldItem is NavSignOutItem && newItem is NavSignOutItem ->
                    oldItem.icon == newItem.icon && oldItem.titleRes == newItem.titleRes
                else -> false
            }
        }
    }
}