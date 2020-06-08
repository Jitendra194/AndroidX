package com.pills.mydemoapplication.utils.view_utils

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView
import com.pills.mydemoapplication.R
import com.pills.mydemoapplication.utils.extention_utils.getDrawableOrNull

@BindingAdapter("layoutFullscreen")
fun View.bindLayoutFullscreen(previousFullscreen: Boolean, fullscreen: Boolean) {
    if (previousFullscreen != fullscreen && fullscreen) {
        systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }
}

@BindingAdapter(
    "drawableStart",
    "drawableLeft",
    "drawableTop",
    "drawableEnd",
    "drawableRight",
    "drawableBottom",
    requireAll = false
)
fun TextView.bindDrawables(
    @DrawableRes drawableStart: Int? = null,
    @DrawableRes drawableLeft: Int? = null,
    @DrawableRes drawableTop: Int? = null,
    @DrawableRes drawableEnd: Int? = null,
    @DrawableRes drawableRight: Int? = null,
    @DrawableRes drawableBottom: Int? = null
) {
    setCompoundDrawablesWithIntrinsicBounds(
        context.getDrawableOrNull(drawableStart ?: drawableLeft),
        context.getDrawableOrNull(drawableTop),
        context.getDrawableOrNull(drawableEnd ?: drawableRight),
        context.getDrawableOrNull(drawableBottom)
    )
}

@BindingAdapter("set_image")
fun AppCompatImageView.setImageToImageView(@DrawableRes drawable: Int) {
    this.setImageResource(drawable)
}

@BindingAdapter("item_check_state")
fun AppCompatImageView.setSelectedColorStateImage(isChecked: Boolean) {
    TypedValue().let {
        context.theme.resolveAttribute(R.attr.colorOnSurface, it, true)
        ImageViewCompat.setImageTintList(this, ColorStateList.valueOf(ContextCompat.getColor(context, if (isChecked) R.color.green_200 else it.resourceId)))
    }
}

@BindingAdapter("text_item_check_state")
fun MaterialTextView.setSelectedColorStateText(isChecked: Boolean) {
    TypedValue().let {
        context.theme.resolveAttribute(R.attr.colorOnSurface, it, true)
        this.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, if (isChecked) R.color.green_200 else it.resourceId)))
    }
}
