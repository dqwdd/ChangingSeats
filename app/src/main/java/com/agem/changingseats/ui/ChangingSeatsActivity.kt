package com.agem.changingseats.ui

import android.annotation.SuppressLint
import android.os.Bundle
import com.agem.changingseats.BaseActivity
import com.agem.changingseats.databinding.ActivityChangingSeatsBinding
import com.agem.changingseats.dialog.NameChangeDialog
import com.agem.changingseats.dialog.NumberChangeDialog

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
        //반 추가하기
//        binding.btnAddClass.setOnClickListener {
//            val addClassDialog = AddClassDialog.newInstance()
//            addClassDialog.show(supportFragmentManager, "addClassDialog")
//        }
        //인원수로 자리 정하기
        binding.btnNumberChange.setOnClickListener {
            val numberChangeDialog = NumberChangeDialog.newInstance(
                setRandomNumber = {
                    setClear()
                    randomNumberSet(it)
                }
            )
            numberChangeDialog.show(supportFragmentManager, "numberChangeDialog")
        }
        //이름으로 자리 정하기
        binding.btnNameChange.setOnClickListener {
            val nameChangeDialog = NameChangeDialog.newInstance(
                setRandomName = {
                    setClear()
                    randomNameSet(it)
                }
            )
            nameChangeDialog.show(supportFragmentManager, "nameChangeDialog")
        }
    }


    private fun randomNumberSet(value: Int) {
        val randomValue = mutableSetOf<Int>()
        val seatArray = mutableSetOf<Int>()

        while(randomValue.size < value) {
            randomValue.add((1..value).random()) //1부터 value 까지 (value 포함)
        }
        while(seatArray.size < 12) {
            seatArray.add((1..12).random())
        }

        for (i in 0 until value) {
            setNumberSeat(seatArray.elementAt(i), randomValue.elementAt(i))
        }
    }

    private fun setNumberSeat(setNumber: Int, randomNumber: Int) {
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

    private fun randomNameSet(value: MutableSet<String>) {
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
}