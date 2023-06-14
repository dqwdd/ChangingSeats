package com.agem.changingseats

import android.os.Bundle
import com.agem.changingseats.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
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