package com.example1.projectapp


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example1.projectapp.models.Cart
import com.example1.projectapp.databinding.MyitemBinding


class MyMedicamentAdapter(val context: Context, private val cartList: ArrayList<Cart>,private val listener: IDeletecListener) :
    RecyclerView.Adapter<MyMedicamentAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: MyitemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.myitem,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val medicament = cartList[position].medicament
        val bind = holder.binding
        bind.cardView.setOnClickListener {
            var intent = Intent(context, ItemDetailsActivity::class.java)
            intent.putExtra("medicament", medicament)
            context.startActivity(intent)
        }

        bind.cardName.text = medicament.name.toString()
        bind.cardDescription.text = medicament.description.toString()
        bind.cardPrice.text = medicament.price.toString() + "DH"
        Glide.with(context)
            .load(Uri.parse("file:///android_asset/${medicament.image.toString()}"))
            .into(bind.cardImg)
        bind.delete.setOnClickListener {
            listener.delete(Cart(cartList[position].id,1,medicament))
        }


    }

    override fun getItemCount(): Int = cartList.size


    class MyViewHolder(val binding: MyitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}