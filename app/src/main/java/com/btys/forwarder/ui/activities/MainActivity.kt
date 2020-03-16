package com.btys.forwarder.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.btys.forwarder.R

class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy {
        findNavController(R.id.mainActivity_navHostFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onUserLogin() {
        navController.navigate(R.id.action_loginGraph_loginFragment_to_loginGraph_mainFragment)
    }
}
