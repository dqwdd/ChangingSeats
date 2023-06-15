package com.agem.changingseats.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.agem.changingseats.databinding.FragmentNumberChangeDialogBinding
import java.io.IOException

class NumberChangeDialog : DialogFragment() {

    private lateinit var binding: FragmentNumberChangeDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentNumberChangeDialogBinding.inflate(layoutInflater, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(true)

        binding.btnPickASeat.setOnClickListener {
            try {
                if (binding.etHowManyMember.text.toString().toInt() > 12) return@setOnClickListener

                setRandomNumber?.let {
                    it(binding.etHowManyMember.text.toString().toInt())
                }

                Toast.makeText(requireContext(), "자리를 뽑았습니다!", Toast.LENGTH_SHORT).show()
                dismiss()
            } catch (e: IOException) {
                Toast.makeText(requireContext(), "에러입니다", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    companion object {
        private var setRandomNumber: ((numberOfMember: Int) -> Unit)? = null

        fun newInstance(
            setRandomNumber: ((numberOfMember: Int) -> Unit)? = null
        ): NumberChangeDialog {
            Companion.setRandomNumber = setRandomNumber

            return NumberChangeDialog()
        }
    }
}