package com.pills.mydemoapplication.utils.animation_utils

import android.view.View
import androidx.annotation.FloatRange
import com.pills.mydemoapplication.utils.extention_utils.normalize

interface OnSlideAction {
    fun onSlide(sheet: View, @FloatRange(from = -1.0, fromInclusive = true, to = 1.0, toInclusive = true) slideOffset: Float)
}

class HalfClockwiseRotateSlideAction(private val view: View) :
    OnSlideAction {
    override fun onSlide(sheet: View, slideOffset: Float) {
        view.rotation = slideOffset.normalize(-1F, 0F, 0F, 180F)
    }
}

class AlphaSlideAction(private val view: View, private val reverse: Boolean = false) :
    OnSlideAction {
    override fun onSlide(sheet: View, slideOffset: Float) {
        val alpha = slideOffset.normalize(-1F, 0F, 0F, 1F)
        view.alpha = if (!reverse) alpha else 1F - alpha
    }
}
