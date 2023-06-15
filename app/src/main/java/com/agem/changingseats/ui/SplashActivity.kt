package com.agem.changingseats.ui

import android.annotation.SuppressLint
import android.os.Bundle
import com.agem.changingseats.BaseActivity
import com.agem.changingseats.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setValues()
        setupEvent()
    }

    override fun setValues() {
//        val myHandler = Handler(Looper.getMainLooper())
//        myHandler.postDelayed({
//            val mIntent = Intent(mContext, LoginActivity::class.java)
//            startActivity(mIntent)
//            finish()
//        }, 1500)
    }

    override fun setupEvent() {
        //
    }
}