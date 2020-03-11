package com.btys.forwarder.ui.app.ext

import androidx.fragment.app.Fragment
import com.btys.forwarder.ui.activities.MainActivity
import com.btys.forwarder.ui.app.ForwarderApplication


fun Fragment.mainApplication() = activity?.application as ForwarderApplication
fun Fragment.mainActivity() = activity as MainActivity