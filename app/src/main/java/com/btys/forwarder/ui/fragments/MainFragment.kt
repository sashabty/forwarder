package com.btys.forwarder.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.btys.forwarder.R
import com.btys.forwarder.ui.views.StatusView
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = View.inflate(context, R.layout.fragment_main, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentMain_statusView.updateStatus(StatusView.Status.FREE)
        fragmentMain_confirmButton.text = getString(R.string.mainFragment_test)
        fragmentMain_waybillNumberTextView.isGone = true
        replaceFragment(EmptyWaybillFragment())

        fragmentMain_confirmButton.setOnClickListener {
            when (childFragmentManager.findFragmentById(R.id.fragmentMain_fragmentContainerView)) {
                is EmptyWaybillFragment -> {
                    replaceFragment(WaybillInfoFragment())
                    fragmentMain_statusView.updateStatus(StatusView.Status.ON_WAY)
                    fragmentMain_confirmButton.text = getString(R.string.mainFragment_deliver)
                    fragmentMain_waybillNumberTextView.isVisible = true
                }
                is WaybillInfoFragment -> {
                    replaceFragment(WaybillFillFormFragment())
                    fragmentMain_confirmButton.text = getString(R.string.mainFragment_submit)
                }
                is WaybillFillFormFragment -> {
                    replaceFragment(FinishWaybillFragment())
                    fragmentMain_confirmButton.text = getString(R.string.mainFragment_scanFinish)
                }
                is FinishWaybillFragment -> {
                    replaceFragment(EmptyWaybillFragment())
                    fragmentMain_statusView.updateStatus(StatusView.Status.FREE)
                    fragmentMain_confirmButton.text = getString(R.string.mainFragment_test)
                    fragmentMain_waybillNumberTextView.isGone = true
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.commit {
            replace(R.id.fragmentMain_fragmentContainerView, fragment)
        }
    }
}