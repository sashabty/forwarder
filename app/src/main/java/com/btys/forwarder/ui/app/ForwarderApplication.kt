package com.btys.forwarder.ui.app

import android.app.Application
import android.content.Context

const val PREFERENCES_FILE_NAME = "FORWARDER_PREFERENCES"

class ForwarderApplication : Application() {

    val prefs by lazy {
        getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    }
}