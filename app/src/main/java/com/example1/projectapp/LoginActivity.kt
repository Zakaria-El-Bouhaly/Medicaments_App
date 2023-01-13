package com.example1.projectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example1.projectapp.Models.User
import com.example1.projectapp.databinding.ActivityLoginBinding
import com.example1.projectapp.viewModels.CartViewModel
import com.example1.projectapp.viewModels.UserViewModel
import com.example1.projectapp.viewModels.VMFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        val viewModelFactory = VMFactory(this.application)
        userViewModel = ViewModelProvider(this,viewModelFactory)[UserViewModel::class.java]
        binding.btnLogin.setOnClickListener {

                val user:User? = userViewModel.findByEmail(binding.email.text.toString())
                if(user != null ){
                    if ((user.email == binding.email.text.toString()) && (user.password == binding.password.text.toString())) {
                        Toast.makeText(this, "EveryThing Fine", Toast.LENGTH_SHORT).show();
                        PreferencesHandler.setUser(this, user.userId);
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Please enter valid credentials..", Toast.LENGTH_SHORT)
                            .show();
                    }
                }else{
                    Toast.makeText(this, "Please register first", Toast.LENGTH_SHORT)
                        .show();
                }



//            observe(this, Observer {
//                val user:User = it
//                if(user.email == binding.email.text.toString() && user.password == binding.password.text.toString()){
//                    Toast.makeText(this, "EveryThing Fine", Toast.LENGTH_SHORT).show();
//                    PreferencesHandler.setUser(this,user.userId);
//                    startActivity(Intent(this,MainActivity::class.java))
//                    finish()
//                }else{
//                    Toast.makeText(this, "Please enter valid credentials..", Toast.LENGTH_SHORT).show();
//                }
//            })
        }
        binding.register.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
            finish()
        }

    }

}