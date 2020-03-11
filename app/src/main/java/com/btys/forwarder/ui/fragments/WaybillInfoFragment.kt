package com.btys.forwarder.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import com.btys.forwarder.R
import com.btys.forwarder.ui.app.ext.dp
import com.btys.forwarder.ui.app.ext.px
import com.google.android.material.textview.MaterialTextView
import kotlinx.android.synthetic.main.fragment_waybill_info.*

class WaybillInfoFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = View.inflate(context, R.layout.fragment_waybill_info, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fillWithSampleData()
    }

    private fun fillWithSampleData() {
        fragmentWaybillInfo_contractorTextView.text = "Контрагент DES"
        fragmentWaybillInfo_addressTextView.text = "г. Пенза, ул. Бакунина, 60"
        fragmentWaybillInfo_documentTextView.text = "Документ №123944"
        fragmentWaybillInfo_amountTextView.text = "19999р"
        fragmentWaybillInfo_capacityTextView.text = "14"
        fragmentWaybillInfo_wrapperColorTextView.text = "Синий"

        context?.let {
            val tv = MaterialTextView(it)
            tv.text = "Примечание 1"
            tv.layoutParams = fragmentWaybillInfo_notesLinearLayout.layoutParams
            tv.updateLayoutParams<LinearLayout.LayoutParams> {
                this.width = LinearLayout.LayoutParams.MATCH_PARENT
                this.height = LinearLayout.LayoutParams.MATCH_PARENT
            }
            tv.setPadding(32.px, 16.px, 32.px, 16.px)

            fragmentWaybillInfo_notesLinearLayout.addView(tv)

            val tv2 = MaterialTextView(it)
            tv2.text = "Примечание 2"
            tv2.layoutParams = fragmentWaybillInfo_notesLinearLayout.layoutParams
            tv2.updateLayoutParams<LinearLayout.LayoutParams> {
                this.width = LinearLayout.LayoutParams.MATCH_PARENT
                this.height = LinearLayout.LayoutParams.MATCH_PARENT
            }
            tv2.setPadding(32.px, 16.px, 32.px, 16.px)

            fragmentWaybillInfo_notesLinearLayout.addView(tv2)
        }
    }
}