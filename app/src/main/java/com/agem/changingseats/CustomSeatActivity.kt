package com.agem.changingseats

import android.os.Bundle
import com.agem.changingseats.databinding.ActivityCustomSeatBinding

class CustomSeatActivity : BaseActivity() {

    lateinit var binding: ActivityCustomSeatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomSeatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //번호로 고정하기나 이름으로 고정했을 때 송이 실수할 거 주의하거나 아예 안되게 하기
        setValues()
        setupEvent()
    }

    override fun setValues() {
        //
    }

    override fun setupEvent() {
    }
}