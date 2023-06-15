package com.agem.changingseats.ui

import android.os.Bundle
import com.agem.changingseats.BaseActivity
import com.agem.changingseats.databinding.ActivityCustomSeatBinding

class CustomSeatActivity : BaseActivity() {

    private val binding by lazy { ActivityCustomSeatBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //번호로 고정하기나 이름으로 고정했을 때 송이 실수할 거 주의하거나 아예 안되게 하기
        setValues()
        setupEvent()
    }

    override fun setValues() {
        //
    }

    override fun setupEvent() {
        binding.btnNumberFix.setOnClickListener {
            //
        }
        binding.btnNameFix.setOnClickListener {
            //
        }
    }
}