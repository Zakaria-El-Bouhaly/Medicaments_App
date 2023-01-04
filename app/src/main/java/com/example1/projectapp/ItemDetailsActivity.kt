package com.example1.projectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example1.projectapp.Models.Medicament
import com.example1.projectapp.databinding.ActivityItemDetailsBinding
import com.example1.projectapp.viewModels.MedicamentViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class ItemDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityItemDetailsBinding
    lateinit var medicament: Medicament
    private lateinit var medicamentViewModel: MedicamentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_details)
        var medicament = intent.getSerializableExtra("medicament")  as Medicament

        Log.d("TEST!!!",medicament.name.toString())


    }
}