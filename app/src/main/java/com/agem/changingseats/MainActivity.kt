package com.agem.changingseats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agem.changingseats.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    private var mClickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setValues()
        setupEvent()
    }

    override fun setValues() {
        //
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
            if (mClickCount >= 7) {
                val mIntent = Intent(mContext, CustomSeatActivity::class.java)
                startActivity(mIntent)
            }
            else mClickCount = 0

            return@setOnLongClickListener false
        }
    }
}