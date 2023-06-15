package com.agem.changingseats.util

import android.content.Context
import org.json.JSONObject

object SharedPref {
    private const val prefName = "SharedPreferences"

    private const val placement = "PLACEMENT"
    private const val saveType = "SAVE_TYPE"

    //자리값을 HashMap 으로 저장
    fun setFixPlacement(context: Context, mSetPlacement: HashMap<String, String>) {
        val json = JSONObject(mSetPlacement as Map<*, *>)
        val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        pref.edit().putString(placement, json.toString()).apply()
    }
    fun getFixPlacement(context: Context): String {
        val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        return pref.getString(placement, "")!!
    }

    //저장한 유형
    fun setSaveType(context: Context, mType: String) {
        val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        pref.edit().putString(saveType, mType).apply()
    }
    fun getSaveType(context: Context): String {
        val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        return pref.getString(saveType, "noSave")!!
    }
}