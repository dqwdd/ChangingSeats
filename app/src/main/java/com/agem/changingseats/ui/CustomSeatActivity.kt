package com.agem.changingseats.ui

import android.os.Bundle
import android.widget.Toast
import com.agem.changingseats.BaseActivity
import com.agem.changingseats.databinding.ActivityCustomSeatBinding
import com.agem.changingseats.util.SharedPref

class CustomSeatActivity : BaseActivity() {

    private val binding by lazy { ActivityCustomSeatBinding.inflate(layoutInflater) }

    private val hash = HashMap<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setValues()
        setupEvent()
    }

    override fun setValues() {}

    override fun setupEvent() {
        binding.btnSave.setOnClickListener {
            if (binding.etSeat1.text.toString().trim() != "") hash["seat1"] = binding.etSeat1.text.toString()
            if (binding.etSeat2.text.toString().trim() != "") hash["seat2"] = binding.etSeat2.text.toString()
            if (binding.etSeat3.text.toString().trim() != "") hash["seat3"] = binding.etSeat3.text.toString()
            if (binding.etSeat4.text.toString().trim() != "") hash["seat4"] = binding.etSeat4.text.toString()
            if (binding.etSeat5.text.toString().trim() != "") hash["seat5"] = binding.etSeat5.text.toString()
            if (binding.etSeat6.text.toString().trim() != "") hash["seat6"] = binding.etSeat6.text.toString()
            if (binding.etSeat7.text.toString().trim() != "") hash["seat7"] = binding.etSeat7.text.toString()
            if (binding.etSeat8.text.toString().trim() != "") hash["seat8"] = binding.etSeat8.text.toString()
            if (binding.etSeat9.text.toString().trim() != "") hash["seat9"] = binding.etSeat9.text.toString()
            if (binding.etSeat10.text.toString().trim() != "") hash["seat10"] = binding.etSeat10.text.toString()
            if (binding.etSeat11.text.toString().trim() != "") hash["seat11"] = binding.etSeat11.text.toString()
            if (binding.etSeat12.text.toString().trim() != "") hash["seat12"] = binding.etSeat12.text.toString()

            SharedPref.setFixPlacement(mContext, hash)
            Toast.makeText(mContext, "저장 되었습니다", Toast.LENGTH_SHORT).show()
        }
        binding.btnClear.setOnClickListener {
            setClear()
            hash.clear()
            SharedPref.setFixPlacement(mContext, hash)
            Toast.makeText(mContext, "초기화 되었습니다", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setClear() {
        binding.etSeat1.setText("")
        binding.etSeat2.setText("")
        binding.etSeat3.setText("")
        binding.etSeat4.setText("")
        binding.etSeat5.setText("")
        binding.etSeat6.setText("")
        binding.etSeat7.setText("")
        binding.etSeat8.setText("")
        binding.etSeat9.setText("")
        binding.etSeat10.setText("")
        binding.etSeat11.setText("")
        binding.etSeat12.setText("")
    }
}