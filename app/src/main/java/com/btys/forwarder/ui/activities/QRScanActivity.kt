package com.btys.forwarder.ui.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.btys.forwarder.ui.app.IntentParams
import me.dm7.barcodescanner.zxing.ZXingScannerView

class QRScanActivity : Activity() {

    private val scannerView: ZXingScannerView by lazy {
        ZXingScannerView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(scannerView)
    }

    override fun onResume() {
        super.onResume()
        scannerView.setResultHandler { result ->
            setResult(RESULT_OK, Intent().apply {
                putExtra(IntentParams.SCAN_RESULT, result.text)
            })
            finish()
        }
        scannerView.startCamera()
    }

    override fun onPause() {
        super.onPause()
        scannerView.stopCamera()
    }
}