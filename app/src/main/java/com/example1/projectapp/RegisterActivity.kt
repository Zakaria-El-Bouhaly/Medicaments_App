package com.example1.projectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example1.projectapp.models.User
import com.example1.projectapp.databinding.ActivityRegisterBinding
import com.example1.projectapp.viewModels.UserViewModel
import com.example1.projectapp.viewModels.VMFactory

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        val viewModelFactory = VMFactory(this.application)
        userViewModel = ViewModelProvider(this,viewModelFactory)[UserViewModel::class.java]

        binding.btnRegister.setOnClickListener {
            val user:User = userViewModel.findByEmail(binding.email.text.toString())
            if(user!=null) {
                if (user.email == binding.email.text.toString()) {
                    Toast.makeText(this, "Account Already exists", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                    if (binding.email.text.isNotEmpty() and binding.password.text.isNotEmpty() and binding.name.text.isNotEmpty()){
                        Toast.makeText(this, "EveryThing Fine !", Toast.LENGTH_SHORT).show()
                        userViewModel.insert(User(0,binding.email.text.toString(),binding.password.text.toString()))
                        startActivity(Intent(this,LoginActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this, "Please enter your credentials..", Toast.LENGTH_SHORT).show()
                    }
            }
//            userViewModel.findByEmail(binding.email.text.toString()).observe(this, Observer {
//                if(it.email == binding.email.text.toString()){
//                    Toast.makeText(this, "Account Already exists", Toast.LENGTH_SHORT).show();
//                }else{
//                    if (binding.email.text.isNotEmpty() and binding.password.text.isNotEmpty() and binding.name.text.isNotEmpty()){
//                        Toast.makeText(this, "EveryThing Fine !", Toast.LENGTH_SHORT).show();
//                        userViewModel.insert(User(0,binding.email.text.toString(),binding.password.text.toString()))
//                        startActivity(Intent(this,LoginActivity::class.java))
//                        finish()
//                    }else{
//                        Toast.makeText(this, "Please enter your credentials..", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            })
        }
        binding.login.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }

    }
}