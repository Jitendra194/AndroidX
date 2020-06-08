package com.pills.home_hq.views

import androidx.annotation.DrawableRes
import com.pills.home_hq.R

data class FeatureItem(@DrawableRes val featureImage: Int, val featureName: FeatureItemTitle)

enum class FeatureItemTitle(val featureTitle: String) {
    OrderPills("Order pills"),
    LabReports("Lab reports"),
    Prescriptions("Prescriptions"),
    WellnessTips("Wellness tips")
}

fun getFeatureItems() = arrayOf(
    FeatureItem(R.drawable.solid, FeatureItemTitle.OrderPills),
    FeatureItem(R.drawable.solid, FeatureItemTitle.LabReports),
    FeatureItem(R.drawable.solid, FeatureItemTitle.Prescriptions),
    FeatureItem(R.drawable.solid, FeatureItemTitle.WellnessTips)
)