package com.pills.mydemoapplication.utils.animation_utils

import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.floatingactionbutton.FloatingActionButton

interface OnStateChangedAction {
    fun onStateChanged(sheet: View, newState: Int)
}

class ShowHideFabStateAction(private val fab: FloatingActionButton) : OnStateChangedAction {
    override fun onStateChanged(sheet: View, newState: Int) {
        if (newState == BottomSheetBehavior.STATE_HIDDEN) fab.show()
        else fab.hide()
    }
}

class VisibilityStateAction(private val view: View, private val reverse: Boolean = false) : OnStateChangedAction {
    override fun onStateChanged(sheet: View, newState: Int) {
        val stateHiddenVisibility = if (!reverse) View.GONE else View.VISIBLE
        val stateDefaultVisibility = if (!reverse) View.VISIBLE else View.GONE
        when (newState) {
            BottomSheetBehavior.STATE_HIDDEN -> view.visibility = stateHiddenVisibility
            else -> view.visibility = stateDefaultVisibility
        }
    }
}
