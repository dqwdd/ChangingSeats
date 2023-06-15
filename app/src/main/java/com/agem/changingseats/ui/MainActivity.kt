package com.agem.changingseats.ui

import android.content.Intent
import android.os.Bundle
import com.agem.changingseats.BaseActivity
import com.agem.changingseats.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private var mClickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setValues()
        setupEvent()
    }

    override fun setValues() {}

    override fun setupEvent() {
        binding.btnChangingSeats.setOnClickListener {
            val mIntent = Intent(mContext, ChangingSeatsActivity::class.java)
            startActivity(mIntent)
        }
        binding.tvVersion.setOnClickListener {
            mClickCount += 1
        }
        binding.tvVersion.setOnLongClickListener {
//            if (mClickCount >= 5) {
                val mIntent = Intent(mContext, CustomSeatActivity::class.java)
                startActivity(mIntent)
//            }
//            else mClickCount = 0

            return@setOnLongClickListener false
        }
    }
}