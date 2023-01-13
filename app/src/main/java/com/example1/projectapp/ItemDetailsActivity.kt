package com.example1.projectapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example1.projectapp.models.Cart
import com.example1.projectapp.models.Medicament
import com.example1.projectapp.databinding.ActivityItemDetailsBinding
import com.example1.projectapp.viewModels.CartViewModel
import com.example1.projectapp.viewModels.MedicamentViewModel

class ItemDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityItemDetailsBinding
    lateinit var medicament: Medicament
    private lateinit var medicamentViewModel: MedicamentViewModel
    private lateinit var cartViewModel: CartViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_details)
        var medicament = intent.getSerializableExtra("medicament") as Medicament

        Log.d("TEST!!!", medicament.name.toString())


        Glide.with(this)
            .load(Uri.parse("file:///android_asset/${medicament.image.toString()}"))
            .into(binding.imgMedicament)


        binding.medicamentName.text = medicament.name.toString()
        binding.medicamentDescription.text = medicament.description.toString()
        binding.Type.text = if (medicament.isVitamin == true) "Vitamin" else "Medicament"
        binding.medicamentPrice.text = medicament.price.toString()+"DH"
        binding.dosage.text = medicament.dosage.toString()
        binding.manufacturer.text = medicament.manufacturer.toString()
        binding.substance.text = medicament.substance.toString()
        cartViewModel =  ViewModelProvider(this)[CartViewModel::class.java]
        binding.addToCart.setOnClickListener{
            val cart = Cart(0,PreferencesHandler.getUser(this),medicament)
            cartViewModel.insert(cart)

        }


    }
}