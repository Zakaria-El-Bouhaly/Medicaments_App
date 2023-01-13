package com.example1.projectapp

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example1.projectapp.databinding.ActivityMainBinding
import com.example1.projectapp.helpers.BottomNavigationBehavior


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbarMain)
        val layoutParams =
            binding.bottomNavigationView.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.behavior = BottomNavigationBehavior()

        val btm_navigation = binding.bottomNavigationView
        val navController = findNavController(
            R.id.nav_host_fragment
        )
        btm_navigation.setupWithNavController(navController)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout -> {
                logoutClicked()
            }
            R.id.app_search -> {
//                logoutClicked()

            }
            else -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }
    private  fun logoutClicked(){
        var builder = AlertDialog.Builder(this, R.style.AlertDialogTheme)
        var view = LayoutInflater.from(this).inflate(R.layout.layout_dialog_logout,findViewById(R.id.layoutDialogContainer))
        builder.setView(view)
        val alertDialog = builder.create()
        var cancel = view.findViewById<Button>(R.id.cancel)
        var logout = view.findViewById<Button>(R.id.logout)
        logout.setOnClickListener {
//            PreferencesHandler.setUser(this,-1)
//            startActivity(Intent(this,LoginActivity::class.java))
//            finish()
            alertDialog.dismiss()
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
        }
        cancel.setOnClickListener {
            alertDialog.dismiss()
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
        }
        if (alertDialog.window != null) {
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        alertDialog.show()
    }
}