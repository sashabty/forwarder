package com.btys.forwarder.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.btys.forwarder.R
import com.btys.forwarder.ui.ext.mainActivity
import com.btys.forwarder.ui.views.StatusView
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private val navController by lazy {
        Navigation.findNavController(mainActivity(), R.id.fragmentMain_navHostFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = View.inflate(context, R.layout.fragment_main, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fillWithSampleData()

        fragmentMain_statusView.updateStatus(StatusView.Status.FREE)
        fragmentMain_confirmButton.text = getString(R.string.mainFragment_test)

        fragmentMain_confirmButton.setOnClickListener {
            when (navController.currentDestination?.id) {
                R.id.mainGraph_emptyWaybillFragment -> {
                    navController.navigate(R.id.action_mainGraph_emptyWaybillFragment_to_mainGraph_waybillInfoFragment)
                    fragmentMain_statusView.updateStatus(StatusView.Status.ON_WAY)
                    fragmentMain_confirmButton.text = getString(R.string.mainFragment_deliver)
                    fragmentMain_waybillNumberTextView.text =
                        getString(R.string.mainFragment_waybillNumber, 1222)
                }
                R.id.mainGraph_signatureFragment,
                R.id.mainGraph_waybillInfoFragment -> {
                    navController.navigate(R.id.action_mainGraph_waybillInfoFragment_to_mainGraph_waybillFillFormFragment)
                    fragmentMain_statusView.updateStatus(StatusView.Status.ON_WAY)
                    fragmentMain_confirmButton.text = getString(R.string.mainFragment_submit)
                }
                R.id.mainGraph_waybillFillFormFragment -> {
                    navController.navigate(R.id.action_mainGraph_waybillFillFormFragment_to_mainGraph_finishWaybillFragment)
                    fragmentMain_confirmButton.text = getString(R.string.mainFragment_scanFinish)
                }
                R.id.mainGraph_finishWaybillFragment -> {
                    navController.navigate(R.id.action_mainGraph_finishWaybillFragment_to_mainGraph_emptyWaybillFragment)
                    fragmentMain_statusView.updateStatus(StatusView.Status.FREE)
                    fragmentMain_confirmButton.text = getString(R.string.mainFragment_test)
                    fragmentMain_waybillNumberTextView.text =
                        getString(R.string.mainFragment_waybillNumberEmpty)
                }
                else -> Unit
            }
        }
    }

    fun openSignatureFragment() {
        navController.navigate(R.id.action_mainGraph_waybillFillFormFragment_to_mainGraph_signatureFragment)
        fragmentMain_confirmButton.text = getString(R.string.mainFragment_done)
    }

    fun openFillFormFragment() {
        navController.navigate(R.id.action_mainGraph_finishWaybillFragment_to_mainGraph_waybillFillFormFragment)
        fragmentMain_confirmButton.text = getString(R.string.mainFragment_submit)
    }

    private fun fillWithSampleData() {
        fragmentMain_userNameTextView.text = "Иванов Сергей Петрович"
        fragmentMain_waybillNumberTextView.text =
            getString(R.string.mainFragment_waybillNumberEmpty)
    }
}