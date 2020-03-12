package com.btys.forwarder.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.btys.forwarder.R
import com.btys.forwarder.ui.fragments.LoginFragment

class MainActivity : AppCompatActivity() {

    lateinit var loginFragment: LoginFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addLoginFragment()
    }

    private fun addLoginFragment() {
        loginFragment = LoginFragment()
        supportFragmentManager.commit {
            setCustomAnimations(R.anim.fragment_fly_in_from_bottom, 0)
            add(R.id.mainActivity_fragmentContainerView, loginFragment)
        }
    }

    fun replaceFragment(
        fragment: Fragment,
        enterAnim: Int = android.R.anim.fade_in,
        exitAnim: Int = 0,
        popEnterAnim: Int = 0,
        popExitAnim: Int = 0
    ) {
        supportFragmentManager.commit {
            setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim)
            replace(R.id.mainActivity_fragmentContainerView, fragment)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
