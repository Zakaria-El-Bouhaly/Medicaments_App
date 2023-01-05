package com.example1.projectapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example1.projectapp.Models.Medicament
import com.example1.projectapp.databinding.FragmentHomeBinding
import com.example1.projectapp.viewModels.MedicamentViewModel


class HomeFragment : Fragment() {
    private lateinit var medicamentViewModel: MedicamentViewModel
    private var medicamentList: ArrayList<Medicament> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.recycleView.layoutManager = GridLayoutManager(context, 2)
        val adapter = MedicamentAdapter(requireContext(), medicamentList)
        binding.recycleView.adapter = adapter
        medicamentViewModel = ViewModelProvider(this,defaultViewModelProviderFactory)[MedicamentViewModel::class.java]
        medicamentViewModel.allMedicaments.observe(requireActivity(), Observer {
            medicamentList.clear()
            medicamentList.addAll(it)
            adapter.notifyDataSetChanged()
        })
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}