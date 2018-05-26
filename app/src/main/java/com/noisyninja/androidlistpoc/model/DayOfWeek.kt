package com.noisyninja.androidlistpoc.model

/**
 * enum to hold day of the week
 * Created by sudiptadutta on 15/05/18.
 */
enum class DayOfWeek(private val text: String) {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    override fun toString(): String {
        return text
    }
}
