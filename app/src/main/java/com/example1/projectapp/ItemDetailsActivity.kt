package com.example1.projectapp

import MyViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example1.projectapp.Models.Medicament
import com.example1.projectapp.databinding.ActivityItemDetailsBinding
import com.example1.projectapp.viewModels.MedicamentViewModel

class ItemDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityItemDetailsBinding
    lateinit var medicament: Medicament
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_details)
        val medicamentId = intent.getIntExtra("medicamentId", 1)

//        val medicamentViewModel = ViewModelProvider(this,id).get(MedicamentViewModel::class.java)


        val medicamentViewModel = ViewModelProvider(
            this,
            MyViewModelFactory(application, medicamentId)
        ).get(MedicamentViewModel::class.java)

        medicamentViewModel.MedicamentById.observe(this, Observer {
            medicament = it
        })

    }
}