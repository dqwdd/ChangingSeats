package com.agem.changingseats.dialog

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.agem.changingseats.R
import com.agem.changingseats.databinding.FragmentNameChangeDialogBinding

class NameChangeDialog : DialogFragment() {

    private lateinit var binding: FragmentNameChangeDialogBinding

    private val nameSet = mutableSetOf<String>()

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentNameChangeDialogBinding.inflate(layoutInflater, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(true)

        //이름 추가
        binding.btnNameAdd.setOnClickListener {

            val memberName = binding.etMemberName.text

            if (memberName.toString() == "" || memberName.toString().trim() == "") return@setOnClickListener

            val mInflater = LayoutInflater.from(requireContext())
            val nameTextItemView = mInflater.inflate(R.layout.item_add_text_view, null)
            val tvOfItemView = nameTextItemView.findViewById<TextView>(R.id.tv_name)

            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
            params.setMargins(10, 10, 10, 10)
            nameTextItemView.layoutParams = params

            tvOfItemView.text = memberName.trim()

            for (i in 0 until nameSet.size) {
                if (nameSet.elementAt(i) == memberName.toString().trim()) {
                    Toast.makeText(requireContext(), "이미 추가된 이름입니다.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            binding.layoutName.addView(nameTextItemView)
            nameSet.add(memberName.toString().trim())
            binding.etMemberName.setText("")

            //추가된 이름 제거
            tvOfItemView.setOnClickListener {
                nameSet.remove(memberName.toString())
                (nameTextItemView.parent as ViewGroup).removeView(nameTextItemView)
            }
        }

        //자리뽑기
        binding.btnPickASeat.setOnClickListener {
            try {
                setRandomName?.let {
                    it(nameSet)
                }

                Toast.makeText(requireContext(), "자리를 뽑았습니다!", Toast.LENGTH_SHORT).show()
                dismiss()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "에러입니다", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    companion object {
        private var setRandomName: ((value: MutableSet<String>) -> Unit)? = null

        fun newInstance(
            setRandomName: ((value: MutableSet<String>) -> Unit)? = null
        ): NameChangeDialog {
            Companion.setRandomName = setRandomName

            return NameChangeDialog()
        }
    }
}