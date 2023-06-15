package com.agem.changingseats.util

import android.content.Context
import org.json.JSONObject

object SharedPref {
    private const val prefName = "SharedPreferences"

    private const val setPlacement = "SET_PLACEMENT"

    //자리값을 HashMap 으로 저장
    fun setFixPlacement(context: Context, mSetPlacement: HashMap<String, String>) {
        val json = JSONObject(mSetPlacement as Map<*, *>)
        val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        pref.edit().putString(setPlacement, json.toString()).apply()
    }
    fun getFixPlacement(context: Context): String {
        val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        return pref.getString(setPlacement, "")!!
    }
}