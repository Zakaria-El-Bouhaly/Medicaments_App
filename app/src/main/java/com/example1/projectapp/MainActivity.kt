package com.example1.projectapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example1.projectapp.databinding.ActivityMainBinding
import com.example1.projectapp.helpers.BottomNavigationBehavior
import androidx.navigation.ui.setupWithNavController


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val layoutParams =
            binding.bottomNavigationView.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.behavior = BottomNavigationBehavior()

        val btm_navigation = binding.bottomNavigationView
        val navController = findNavController(
            R.id.nav_host_fragment
        )
        btm_navigation.setupWithNavController(navController)


    }
}