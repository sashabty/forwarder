package com.btys.forwarder.ui.ext

import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import androidx.core.app.ActivityCompat

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Context.isPermissionGranted(permission: String) =
    ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED