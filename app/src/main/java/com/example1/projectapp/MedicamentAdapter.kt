package com.example1.projectapp


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example1.projectapp.Models.Medicament
import com.example1.projectapp.databinding.ItemBinding


class MedicamentAdapter(val context: Context, private val medicamentList: ArrayList<Medicament>) :
    RecyclerView.Adapter<MedicamentAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val medicament = medicamentList[position]
        val bind = holder.binding
        bind.cardView.setOnClickListener {
            var intent = Intent(context, ItemDetailsActivity::class.java)
            intent.putExtra("medicament",medicament)
            context.startActivity(intent)
        }


        bind.txtProductName.text = medicament.name.toString()
        bind.txtProductPieces.text = medicament.description.toString()
        bind.txtProductPrice.text = medicament.price.toString()

        Glide.with(context)
            .load(Uri.parse("file:///android_asset/${medicament.image.toString()}"))
            .into(bind.imgProductImage)


    }

    override fun getItemCount(): Int = medicamentList.size


    class MyViewHolder(val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}