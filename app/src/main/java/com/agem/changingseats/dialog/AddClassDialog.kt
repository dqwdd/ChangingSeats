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
import com.agem.changingseats.databinding.FragmentAddClassDialogBinding

class AddClassDialog : DialogFragment() {

    private lateinit var binding: FragmentAddClassDialogBinding

    private val nameSet = mutableSetOf<String>()
    private var classAddViewItem: View? = null

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAddClassDialogBinding.inflate(layoutInflater, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(true)

        //반 이름 추가하기
        binding.btnClassAdd.setOnClickListener {
            //반 이름은 1개만 가능
            if (classAddViewItem != null) {
                (classAddViewItem!!.parent as ViewGroup).removeView(classAddViewItem)
                classAddViewItem = null
            }
            val mClassName = binding.etClassName.text

            val mInflater = LayoutInflater.from(requireContext())
            val nameTextItemView = mInflater.inflate(R.layout.item_add_text_view, null)
            val tvOfItemView = nameTextItemView.findViewById<TextView>(R.id.tv_name)

            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
            params.setMargins(10, 10, 10, 10)
            nameTextItemView.layoutParams = params

            tvOfItemView.text = mClassName

            classAddViewItem = nameTextItemView
            binding.layoutClass.addView(nameTextItemView)
            binding.etMemberName.setText("")

            tvOfItemView.setOnClickListener {
                (nameTextItemView.parent as ViewGroup).removeView(nameTextItemView)
            }
        }

        //이름 추가하기
        binding.btnNameAdd.setOnClickListener {

            val memberName = binding.etMemberName.text

            if (memberName.toString() == "") return@setOnClickListener

            val mInflater = LayoutInflater.from(requireContext())
            val nameTextItemView = mInflater.inflate(R.layout.item_add_text_view, null)
            val tvOfItemView = nameTextItemView.findViewById<TextView>(R.id.tv_name)

            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
            params.setMargins(10, 10, 10, 10)
            nameTextItemView.layoutParams = params

            tvOfItemView.text = memberName

            for (i in 1 until nameSet.size) {
                if (nameSet.elementAt(i) == memberName.toString()) {
                    Toast.makeText(requireContext(), "이미 추가된 이름입니다.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            binding.layoutName.addView(nameTextItemView)
            nameSet.add(memberName.toString())
            binding.etMemberName.setText("")

            //추가된 이름 제거
            tvOfItemView.setOnClickListener {
                nameSet.remove(memberName.toString())
                (nameTextItemView.parent as ViewGroup).removeView(nameTextItemView)
            }
        }

        //반 저장하기
        binding.btnAddClass.setOnClickListener {
            if (classAddViewItem == null) {
                Toast.makeText(requireContext(), "반 이름을 설정해주세요!", Toast.LENGTH_SHORT).show()
            }
            if (nameSet.size == 0) {
                Toast.makeText(requireContext(), "구성원을 설정해주세요!", Toast.LENGTH_SHORT).show()
            }

            //여긴 추가 해놔야 함
//            SharedPref.setClass(requireContext(), )
        }

        return binding.root
    }

    companion object {
        fun newInstance(): AddClassDialog {
            return AddClassDialog()
        }
    }
}