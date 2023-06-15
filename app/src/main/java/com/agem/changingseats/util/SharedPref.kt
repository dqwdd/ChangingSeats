package com.agem.changingseats.util

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object SharedPref {
    private const val prefName = "SharedPreferences"

    private const val setClass = "SET_CLASS"

    private const val seatName1 = "SEAT_NAME_1"
    private const val seatName2 = "SEAT_NAME_2"
    private const val seatName3 = "SEAT_NAME_3"
    private const val seatName4 = "SEAT_NAME_4"
    private const val seatName5 = "SEAT_NAME_5"
    private const val seatName6 = "SEAT_NAME_6"
    private const val seatName7 = "SEAT_NAME_7"
    private const val seatName8 = "SEAT_NAME_8"
    private const val seatName9 = "SEAT_NAME_9"
    private const val seatName10 = "SEAT_NAME_10"
    private const val seatName11 = "SEAT_NAME_11"
    private const val seatName12 = "SEAT_NAME_12"

    //Class
    fun setClass(context: Context, mClass: Array<String>) {
        val gson = Gson()
        val json = gson.toJson(mClass)
        val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        pref.edit().putString(setClass, json).apply()
    }
    fun getClass(context: Context): Array<String> {
        val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        val json = pref.getString(setClass, null)
        val gson = Gson()

        return gson.fromJson(json, object : TypeToken<Array<String?>>() {}.type)
    }

    //seatName-1
    fun setSeatName1(context: Context, seatNumber: String) {
        val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        pref.edit().putString(seatName1, seatNumber).apply()
    }
    fun getSeatName1(context: Context): String {
        val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        return pref.getString(seatName1, "")!!
    }
}