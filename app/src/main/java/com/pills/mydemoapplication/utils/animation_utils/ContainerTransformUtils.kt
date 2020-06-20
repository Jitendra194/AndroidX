package com.pills.mydemoapplication.utils.animation_utils

import com.google.android.material.transition.MaterialContainerTransform
import com.pills.mydemoapplication.R

fun MaterialContainerTransform.getEnterAnimation(): MaterialContainerTransform {
    fadeMode = MaterialContainerTransform.FADE_MODE_IN
    drawingViewId = R.id.main_hq_navigation
    duration = 350.toLong()
    return this
}

fun MaterialContainerTransform.getExitAnimation() = this.apply {
    fadeMode = MaterialContainerTransform.FADE_MODE_OUT
    drawingViewId = R.id.main_hq_navigation
    duration = 350.toLong()
}