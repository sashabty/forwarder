package com.btys.forwarder.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.btys.forwarder.R
import com.google.android.material.textview.MaterialTextView

class StatusView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyle, defStyleRes) {

    lateinit var statusTextView: MaterialTextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_status, this, true)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        statusTextView = findViewById(R.id.viewStatus_statusTextView)
    }

    fun updateStatus(newStatus: Status) {
        when (newStatus) {
            Status.FREE -> {
                statusTextView.apply {
                    setTextColor(ContextCompat.getColor(context, R.color.status_view_free_text))
                    text = context.resources.getString(R.string.statusView_free)
                }
                background = ContextCompat.getDrawable(context, R.drawable.bg_view_status_free)
            }
            Status.ON_WAY -> {
                statusTextView.apply {
                    setTextColor(ContextCompat.getColor(context, R.color.status_view_busy_text))
                    text = context.resources.getString(R.string.statusView_onWay)
                }
                background = ContextCompat.getDrawable(context, R.drawable.bg_view_status_busy)
            }
        }
    }

    enum class Status { FREE, ON_WAY }
}