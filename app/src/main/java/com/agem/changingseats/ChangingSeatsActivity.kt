package com.agem.changingseats

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import android.text.util.Linkify
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.agem.changingseats.databinding.ActivityChangingSeatsBinding
import java.util.regex.Pattern

class ChangingSeatsActivity : BaseActivity() {

    lateinit var binding: ActivityChangingSeatsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangingSeatsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setValues()
        setupEvent()
    }

    override fun setValues() {
        //
    }

    override fun setupEvent() {
        binding.btnNameChange.setOnClickListener {
            val alert = Dialog(this@ChangingSeatsActivity)
            alert.setContentView(R.layout.dialog_number_change)
            alert.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            alert.setCancelable(false)

//            val tvTitle = alert.findViewById<TextView>(R.id.tv_title)
            val etHowManyMember = alert.findViewById<EditText>(R.id.et_how_many_member)
            val btnPickASeat = alert.findViewById<Button>(R.id.btn_pick_a_seat)

            val et = etHowManyMember.text
            Log.e("tetest", "44")
            Log.e("tetest", "et == $et")

            alert.show()

            btnPickASeat.setOnClickListener {
                Toast.makeText(mContext, "자리를 뽑았습니다!", Toast.LENGTH_SHORT).show()
                alert.dismiss()
            }
        }
    }
}