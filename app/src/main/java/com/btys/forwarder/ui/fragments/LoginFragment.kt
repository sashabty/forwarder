package com.btys.forwarder.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.btys.forwarder.R
import com.btys.forwarder.ui.app.Prefs
import com.btys.forwarder.ui.app.ext.mainActivity
import com.btys.forwarder.ui.app.ext.mainApplication
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = View.inflate(context, R.layout.fragment_login, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (mainApplication().prefs.getBoolean(Prefs.REMEMBER_ME, false)) {
            fragmentLogin_loginEditText.setText(
                mainApplication().prefs.getString(Prefs.LOGIN, "")
            )
            fragmentLogin_passwordEditText.setText(
                mainApplication().prefs.getString(Prefs.PASSWORD, "")
            )
            fragmentLogin_rememberMeCheckBox.isChecked = true
        }

        fragmentLogin_rememberMeTextView.setOnClickListener {
            fragmentLogin_rememberMeCheckBox.isChecked = !fragmentLogin_rememberMeCheckBox.isChecked
        }

        fragmentLogin_rememberMeCheckBox.setOnCheckedChangeListener { _, isChecked ->
            mainApplication().prefs.edit {
                putBoolean(Prefs.REMEMBER_ME, isChecked)
            }

            if (isChecked) {
                mainApplication().prefs.edit {
                    putString(
                        Prefs.LOGIN,
                        fragmentLogin_loginEditText.text.toString()
                    )
                    putString(
                        Prefs.PASSWORD,
                        fragmentLogin_passwordEditText.text.toString()
                    )
                }

            } else {
                mainApplication().prefs.edit {
                    putString(Prefs.LOGIN, "")
                    putString(Prefs.PASSWORD, "")
                }
            }
        }

        fragmentLogin_loginEditText.addTextChangedListener {
            if (fragmentLogin_rememberMeCheckBox.isChecked) {
                mainApplication().prefs.edit {
                    putString(Prefs.LOGIN, it.toString())
                }
            }
        }

        fragmentLogin_passwordEditText.addTextChangedListener {
            if (fragmentLogin_rememberMeCheckBox.isChecked) {
                mainApplication().prefs.edit {
                    putString(Prefs.PASSWORD, it.toString())
                }
            }
        }

        fragmentLogin_loginButton.setOnClickListener {
            mainActivity().replaceFragment(MainFragment())
        }
    }
}