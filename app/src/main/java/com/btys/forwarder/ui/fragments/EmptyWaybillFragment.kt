package com.btys.forwarder.ui.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.btys.forwarder.R
import com.btys.forwarder.ui.activities.QRScanActivity
import com.btys.forwarder.ui.app.IntentParams
import com.btys.forwarder.ui.app.Requests
import com.btys.forwarder.ui.ext.isPermissionGranted
import com.btys.forwarder.ui.ext.mainActivity
import kotlinx.android.synthetic.main.fragment_empty_waybill.*

class EmptyWaybillFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = View.inflate(context, R.layout.fragment_empty_waybill, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentEmptyWaybill_scanQRButton.setOnClickListener {
            if (requireContext().isPermissionGranted(android.Manifest.permission.CAMERA)) {
                startQRScanActivity()

            } else {
                ActivityCompat.requestPermissions(
                    mainActivity(),
                    arrayOf(android.Manifest.permission.CAMERA),
                    Requests.CAMERA_PERMISSION
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == Requests.CAMERA_PERMISSION
            && requireContext().isPermissionGranted(android.Manifest.permission.CAMERA)
        ) {
            startQRScanActivity()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Requests.SCAN_QR && resultCode == Activity.RESULT_OK) {
            Toast.makeText(
                requireContext(),
                data?.getStringExtra(IntentParams.SCAN_RESULT) ?: "Error",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun startQRScanActivity() {
        startActivityForResult(
            Intent(requireContext(), QRScanActivity::class.java),
            Requests.SCAN_QR
        )
    }
}