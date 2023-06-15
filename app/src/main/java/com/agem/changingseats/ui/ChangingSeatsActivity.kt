package com.agem.changingseats.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.agem.changingseats.BaseActivity
import com.agem.changingseats.databinding.ActivityChangingSeatsBinding
import com.agem.changingseats.dialog.NameChangeDialog
import com.agem.changingseats.dialog.NumberChangeDialog
import com.agem.changingseats.util.SharedPref
import org.json.JSONObject

class ChangingSeatsActivity : BaseActivity() {

    private val binding by lazy { ActivityChangingSeatsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setValues()
        setupEvent()
    }

    override fun setValues() {}

    @SuppressLint("InflateParams")
    override fun setupEvent() {
        //나가기
        binding.ivBack.setOnClickListener {
            finish()
        }
        //인원수로 자리 정하기
        binding.btnNumberChange.setOnClickListener {
            val numberChangeDialog = NumberChangeDialog.newInstance(
                setRandomNumber = {
                    setClear()

                    if (SharedPref.getSaveType(mContext) == "noSave") setRandomNumber(it)
                    else {
                        if (checkFixNumber(it)) setFixPlacementSeat(JSONObject(SharedPref.getFixPlacement(mContext)))
                        else setRandomNumber(it)
                    }
                }
            )
            numberChangeDialog.show(supportFragmentManager, "numberChangeDialog")
        }
        //이름으로 자리 정하기
        binding.btnNameChange.setOnClickListener {
            val nameChangeDialog = NameChangeDialog.newInstance(
                setRandomName = {
                    setClear()

                    if (SharedPref.getSaveType(mContext) == "noSave") setRandomName(it)
                    else {
                        if (checkFixName(it)) setFixPlacementSeat(JSONObject(SharedPref.getFixPlacement(mContext)))
                        else setRandomName(it)
                    }
                }
            )
            nameChangeDialog.show(supportFragmentManager, "nameChangeDialog")
        }
    }


    private fun setRandomNumber(value: Int) {
        val randomValue = mutableSetOf<Int>()
        val seatArray = mutableSetOf<Int>()

        while(randomValue.size < value) {
            randomValue.add((1..value).random()) //1부터 value 까지 (value 포함)
        }
        while(seatArray.size < 12) {
            seatArray.add((1..12).random())
        }

        for (i in 0 until value) {
            setRandomNumberSeat(seatArray.elementAt(i), randomValue.elementAt(i))
        }
    }

    private fun setRandomNumberSeat(setNumber: Int, randomNumber: Int) {
        when (setNumber) {
            1 -> binding.tvSeat1.text = randomNumber.toString()
            2 -> binding.tvSeat2.text = randomNumber.toString()
            3 -> binding.tvSeat3.text = randomNumber.toString()
            4 -> binding.tvSeat4.text = randomNumber.toString()
            5 -> binding.tvSeat5.text = randomNumber.toString()
            6 -> binding.tvSeat6.text = randomNumber.toString()
            7 -> binding.tvSeat7.text = randomNumber.toString()
            8 -> binding.tvSeat8.text = randomNumber.toString()
            9 -> binding.tvSeat9.text = randomNumber.toString()
            10 -> binding.tvSeat10.text = randomNumber.toString()
            11 -> binding.tvSeat11.text = randomNumber.toString()
            12 -> binding.tvSeat12.text = randomNumber.toString()
        }
    }

    private fun checkFixNumber(value: Int): Boolean {
        if (SharedPref.getFixPlacement(mContext).length == value) {
            Log.e("tetest", "124")
        } else {
            Log.e("tetest", "0000")
            Log.e("tetest", "value == $value")
            Log.e("tetest", "SharedPref.getFixPlacement(mContext).length == ${SharedPref.getFixPlacement(mContext).length}")
        }

        return SharedPref.getFixPlacement(mContext).length == value
    }

    private fun setRandomName(value: MutableSet<String>) {
        val randomValue = mutableSetOf<Int>()

        while(randomValue.size < value.size) {
            randomValue.add((1..12).random())
        }

        for (i in 0 until value.size) {
            setRandomNameSeat(value.elementAt(i), randomValue.elementAt(i))
        }
    }

    private fun setRandomNameSeat(name: String, randomNumber: Int) {
        when (randomNumber) {
            1 -> binding.tvSeat1.text = name
            2 -> binding.tvSeat2.text = name
            3 -> binding.tvSeat3.text = name
            4 -> binding.tvSeat4.text = name
            5 -> binding.tvSeat5.text = name
            6 -> binding.tvSeat6.text = name
            7 -> binding.tvSeat7.text = name
            8 -> binding.tvSeat8.text = name
            9 -> binding.tvSeat9.text = name
            10 -> binding.tvSeat10.text = name
            11 -> binding.tvSeat11.text = name
            12 -> binding.tvSeat12.text = name
        }
    }

    private fun checkFixName(it: MutableSet<String>): Boolean {
        if (it.size == JSONObject(SharedPref.getFixPlacement(mContext)).length()) {

            var check = 0
            val objIt = mutableSetOf<String>()
            val fixObj = JSONObject(SharedPref.getFixPlacement(mContext))

            if (fixObj.optString("seat1", "") != "") objIt.add(fixObj.optString("seat1", ""))
            if (fixObj.optString("seat2", "") != "") objIt.add(fixObj.optString("seat2", ""))
            if (fixObj.optString("seat3", "") != "") objIt.add(fixObj.optString("seat3", ""))
            if (fixObj.optString("seat4", "") != "") objIt.add(fixObj.optString("seat4", ""))
            if (fixObj.optString("seat5", "") != "") objIt.add(fixObj.optString("seat5", ""))
            if (fixObj.optString("seat6", "") != "") objIt.add(fixObj.optString("seat6", ""))
            if (fixObj.optString("seat7", "") != "") objIt.add(fixObj.optString("seat7", ""))
            if (fixObj.optString("seat8", "") != "") objIt.add(fixObj.optString("seat8", ""))
            if (fixObj.optString("seat9", "") != "") objIt.add(fixObj.optString("seat9", ""))
            if (fixObj.optString("seat10", "") != "") objIt.add(fixObj.optString("seat10", ""))
            if (fixObj.optString("seat11", "") != "") objIt.add(fixObj.optString("seat11", ""))
            if (fixObj.optString("seat12", "") != "") objIt.add(fixObj.optString("seat12", ""))

            it.forEach { it1 ->
                objIt.forEach { objIt ->
                    if (it1 == objIt) check += 1
                }
            }

            return check == it.size
        } else {
            return false
        }
    }

    private fun setFixPlacementSeat(fixObj: JSONObject) {
        if (fixObj.optString("seat1", "") != "") binding.tvSeat1.text = fixObj.optString("seat1", "")
        if (fixObj.optString("seat2", "") != "") binding.tvSeat2.text = fixObj.optString("seat2", "")
        if (fixObj.optString("seat3", "") != "") binding.tvSeat3.text = fixObj.optString("seat3", "")
        if (fixObj.optString("seat4", "") != "") binding.tvSeat4.text = fixObj.optString("seat4", "")
        if (fixObj.optString("seat5", "") != "") binding.tvSeat5.text = fixObj.optString("seat5", "")
        if (fixObj.optString("seat6", "") != "") binding.tvSeat6.text = fixObj.optString("seat6", "")
        if (fixObj.optString("seat7", "") != "") binding.tvSeat7.text = fixObj.optString("seat7", "")
        if (fixObj.optString("seat8", "") != "") binding.tvSeat8.text = fixObj.optString("seat8", "")
        if (fixObj.optString("seat9", "") != "") binding.tvSeat9.text = fixObj.optString("seat9", "")
        if (fixObj.optString("seat10", "") != "") binding.tvSeat10.text = fixObj.optString("seat10", "")
        if (fixObj.optString("seat11", "") != "") binding.tvSeat11.text = fixObj.optString("seat11", "")
        if (fixObj.optString("seat12", "") != "") binding.tvSeat12.text = fixObj.optString("seat12", "")
    }

    private fun setClear() {
        binding.tvSeat1.text = " "
        binding.tvSeat2.text = " "
        binding.tvSeat3.text = " "
        binding.tvSeat4.text = " "
        binding.tvSeat5.text = " "
        binding.tvSeat6.text = " "
        binding.tvSeat7.text = " "
        binding.tvSeat8.text = " "
        binding.tvSeat9.text = " "
        binding.tvSeat10.text = " "
        binding.tvSeat11.text = " "
        binding.tvSeat12.text = " "
    }
}