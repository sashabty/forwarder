package com.btys.forwarder.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.btys.forwarder.R
import kotlinx.android.synthetic.main.fragment_waybill_fill_form.*

class WaybillFillFormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = View.inflate(context, R.layout.fragment_waybill_fill_form, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentWaybillFillForm_signClearButton.setOnClickListener {

        }
    }
}