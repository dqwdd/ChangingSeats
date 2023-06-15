package com.agem.changingseats.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.agem.changingseats.BaseActivity
import com.agem.changingseats.databinding.ActivityMainBinding
import com.agem.changingseats.util.SharedPref
import org.json.JSONObject

class MainActivity : BaseActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private var mClickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setValues()
        setupEvent()
    }

    override fun setValues() {


//        val hash = HashMap<String, String>()
//        hash["movie"] = "lala land"
//        hash["music"] = "city of star"
//
//        SharedPref.setFixPlacement(mContext, hash)
//        val obj = JSONObject(SharedPref.getFixPlacement(mContext))
//
//        Log.e("tetest", "movie == ${obj.optString("movie", "")}")
//
//        try {
//            Log.e("tetest", "test == ${obj.optString("test", "")}")
//
//            if (obj.optString("test", "") == "") {
//                Log.e("tetest", "testtt")
//            }
//        } catch (e: Exception) {
//            Log.e("tetest", "e == $e")
//        }

    }

    override fun setupEvent() {
        binding.btnChangingSeats.setOnClickListener {
            val mIntent = Intent(mContext, ChangingSeatsActivity::class.java)
            startActivity(mIntent)
        }
        binding.tvVersion.setOnClickListener {
            mClickCount += 1
        }
        binding.tvVersion.setOnLongClickListener {
            if (mClickCount >= 5) {
                val mIntent = Intent(mContext, CustomSeatActivity::class.java)
                startActivity(mIntent)
            }
            else mClickCount = 0

            return@setOnLongClickListener false
        }
    }
}