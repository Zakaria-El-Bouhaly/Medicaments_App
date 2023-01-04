package com.example1.projectapp


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example1.projectapp.Models.Medicament
import com.example1.projectapp.databinding.ItemBinding


class MedicamentAdapter(val context: Context,private val medicamentList:ArrayList<Medicament>): RecyclerView.Adapter<MedicamentAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding : ItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int  = medicamentList.size


    inner class MyViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(){
            binding.cardView.setOnClickListener {
                var intent = Intent(context,ItemDetailsActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}