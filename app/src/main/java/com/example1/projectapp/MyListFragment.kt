package com.example1.projectapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example1.projectapp.Models.Cart
import com.example1.projectapp.Models.Medicament
import com.example1.projectapp.databinding.FragmentMylistBinding
import com.example1.projectapp.databinding.FragmentSearchBinding
import com.example1.projectapp.viewModels.CartViewModel
import com.example1.projectapp.viewModels.MedicamentViewModel

class MyListFragment : Fragment() , IDeletecListener{
    private var cartList: ArrayList<Cart> = ArrayList()
    private var medicament: ArrayList<Medicament> = ArrayList()
    private lateinit var cartViewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMylistBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_mylist, container, false);
        binding.myList.layoutManager = GridLayoutManager(context, 2)
        val adapter = MyMedicamentAdapter(requireContext(),cartList,this)
        binding.myList.adapter = adapter
        cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]
        cartViewModel.getAllCartByUser(1).observe(requireActivity(), Observer {
            cartList.clear()
            cartList.addAll(it)
            adapter.notifyDataSetChanged()
        })
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = MyListFragment()
    }

    override fun delete(cart: Cart) {
        cartViewModel.delete(cart)
    }
}