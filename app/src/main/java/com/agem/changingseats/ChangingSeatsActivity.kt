package com.agem.changingseats

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.agem.changingseats.databinding.ActivityChangingSeatsBinding

class ChangingSeatsActivity : BaseActivity() {

    private lateinit var binding: ActivityChangingSeatsBinding

    private val nameSet = mutableSetOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangingSeatsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setValues()
        setupEvent()
    }

    override fun setValues() {}

    @SuppressLint("InflateParams")
    override fun setupEvent() {
        binding.ivBack.setOnClickListener {
            finish()
        }
        binding.btnNumberChange.setOnClickListener {
            val alert = Dialog(this@ChangingSeatsActivity)
            alert.setContentView(R.layout.dialog_number_change)
            alert.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            alert.setCancelable(true)

            val etHowManyMember = alert.findViewById<EditText>(R.id.et_how_many_member)
            val btnPickASeat = alert.findViewById<Button>(R.id.btn_pick_a_seat)

            val numberOfMember = etHowManyMember.text

            alert.show()

            btnPickASeat.setOnClickListener {
                try {
                    if (numberOfMember.toString().toInt() > 12) return@setOnClickListener

                    setClear()
                    randomNumberSet(numberOfMember.toString().toInt())

                    Toast.makeText(mContext, "자리를 뽑았습니다!", Toast.LENGTH_SHORT).show()
                    alert.dismiss()
                } catch (e: Exception) {
                    Log.e("tetest", "e == $e")
                    Toast.makeText(mContext, "에러입니다", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.btnNameChange.setOnClickListener {
            val nameChangeDialog = NameChangeDialog.newInstance(
                randomNameSet = {
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
            randomValue.add((1..12).random())
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