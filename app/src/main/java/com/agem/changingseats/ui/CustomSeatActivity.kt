package com.agem.changingseats.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.agem.changingseats.BaseActivity
import com.agem.changingseats.databinding.ActivityCustomSeatBinding
import com.agem.changingseats.util.SharedPref
import org.json.JSONObject

class CustomSeatActivity : BaseActivity() {

    private val binding by lazy { ActivityCustomSeatBinding.inflate(layoutInflater) }

    private val hash = HashMap<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setValues()
        setupEvent()
    }

    override fun setValues() {
        if (SharedPref.getSaveType(mContext) != "noSave") showFixSeat(JSONObject(SharedPref.getFixPlacement(mContext)))
    }

    override fun setupEvent() {
        binding.btnSave.setOnClickListener {
            if (binding.etSeat1.text.toString().trim() != "") hash["seat1"] = binding.etSeat1.text.toString().trim()
            if (binding.etSeat2.text.toString().trim() != "") hash["seat2"] = binding.etSeat2.text.toString().trim()
            if (binding.etSeat3.text.toString().trim() != "") hash["seat3"] = binding.etSeat3.text.toString().trim()
            if (binding.etSeat4.text.toString().trim() != "") hash["seat4"] = binding.etSeat4.text.toString().trim()
            if (binding.etSeat5.text.toString().trim() != "") hash["seat5"] = binding.etSeat5.text.toString().trim()
            if (binding.etSeat6.text.toString().trim() != "") hash["seat6"] = binding.etSeat6.text.toString().trim()
            if (binding.etSeat7.text.toString().trim() != "") hash["seat7"] = binding.etSeat7.text.toString().trim()
            if (binding.etSeat8.text.toString().trim() != "") hash["seat8"] = binding.etSeat8.text.toString().trim()
            if (binding.etSeat9.text.toString().trim() != "") hash["seat9"] = binding.etSeat9.text.toString().trim()
            if (binding.etSeat10.text.toString().trim() != "") hash["seat10"] = binding.etSeat10.text.toString().trim()
            if (binding.etSeat11.text.toString().trim() != "") hash["seat11"] = binding.etSeat11.text.toString().trim()
            if (binding.etSeat12.text.toString().trim() != "") hash["seat12"] = binding.etSeat12.text.toString().trim()

            hash.forEach { (_, value) ->
                if (value == "1" || value == "2" || value == "3" || value == "4" || value == "5" ||
                    value == "6" || value == "7" || value == "8" || value == "9" || value == "10" ||
                    value == "11" || value == "12") {
                    SharedPref.setSaveType(mContext, "number")
                } else SharedPref.setSaveType(mContext, "name")
            }

            Log.e("tetest", "Sha10 == ${SharedPref.getFixPlacement(mContext).length}")
            SharedPref.setFixPlacement(mContext, hash)
            Log.e("tetest", "Sha11 == ${SharedPref.getFixPlacement(mContext).length}")
            Toast.makeText(mContext, "저장 되었습니다", Toast.LENGTH_SHORT).show()
        }
        binding.btnClear.setOnClickListener {
            setClear()
            hash.clear()
            SharedPref.setSaveType(mContext, "noSave")
            Log.e("tetest", "Sha21 == ${SharedPref.getFixPlacement(mContext).length}")
            SharedPref.setFixPlacement(mContext, hash)
            Log.e("tetest", "Sha22 == ${SharedPref.getFixPlacement(mContext).length}")
            Toast.makeText(mContext, "초기화 되었습니다", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showFixSeat(fixObj: JSONObject) {
        if (fixObj.optString("seat1", "") != "") binding.etSeat1.setText(fixObj.optString("seat1", ""))
        if (fixObj.optString("seat2", "") != "") binding.etSeat2.setText(fixObj.optString("seat2", ""))
        if (fixObj.optString("seat3", "") != "") binding.etSeat3.setText(fixObj.optString("seat3", ""))
        if (fixObj.optString("seat4", "") != "") binding.etSeat4.setText(fixObj.optString("seat4", ""))
        if (fixObj.optString("seat5", "") != "") binding.etSeat5.setText(fixObj.optString("seat5", ""))
        if (fixObj.optString("seat6", "") != "") binding.etSeat6.setText(fixObj.optString("seat6", ""))
        if (fixObj.optString("seat7", "") != "") binding.etSeat7.setText(fixObj.optString("seat7", ""))
        if (fixObj.optString("seat8", "") != "") binding.etSeat8.setText(fixObj.optString("seat8", ""))
        if (fixObj.optString("seat9", "") != "") binding.etSeat9.setText(fixObj.optString("seat9", ""))
        if (fixObj.optString("seat10", "") != "") binding.etSeat10.setText(fixObj.optString("seat10", ""))
        if (fixObj.optString("seat11", "") != "") binding.etSeat11.setText(fixObj.optString("seat11", ""))
        if (fixObj.optString("seat12", "") != "") binding.etSeat12.setText(fixObj.optString("seat12", ""))
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