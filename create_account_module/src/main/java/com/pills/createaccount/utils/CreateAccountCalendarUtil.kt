package com.pills.createaccount.utils

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

fun MaterialDatePicker.Builder<Long>.setupDOBCalendar(): MaterialDatePicker<Long> {
    val calendar: Calendar = Calendar.getInstance(TimeZone.getDefault())
    return this.setSelection(calendar.timeInMillis)
        .setTitleText("Select date of birth")
        .setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR)
        .setCalendarConstraints(
            CalendarConstraints.Builder().setEnd(calendar.timeInMillis)
                .setValidator(DateValidator()).build()
        )
        .build()
}

@SuppressLint("SimpleDateFormat")
fun Long.convertToDateString(): String = SimpleDateFormat("dd/MM/yyyy").run {
    timeZone = TimeZone.getTimeZone("UTC")
    format(this@convertToDateString)
}

class DateValidator : CalendarConstraints.DateValidator {

    override fun writeToParcel(dest: Parcel?, flags: Int) {}

    override fun isValid(date: Long): Boolean = Calendar.getInstance().timeInMillis > date

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<DateValidator> {
        override fun createFromParcel(parcel: Parcel): DateValidator {
            return DateValidator()
        }

        override fun newArray(size: Int): Array<DateValidator?> {
            return arrayOfNulls(size)
        }
    }
}