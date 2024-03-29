package com.example1.projectapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example1.projectapp.models.Medicament
import com.example1.projectapp.databinding.FragmentSearchBinding
import com.example1.projectapp.viewModels.MedicamentViewModel
import java.util.*
import kotlin.collections.ArrayList

class SearchFragment : Fragment() {

    private var medicamentList: ArrayList<Medicament> = ArrayList()
    private lateinit var medicamentViewModel: MedicamentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentSearchBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);

        binding.searchList.layoutManager = GridLayoutManager(context, 2)
        val adapter = MedicamentAdapter(requireContext(), medicamentList)
        binding.searchList.adapter = adapter
        medicamentViewModel = ViewModelProvider(this)[MedicamentViewModel::class.java]


        binding.searchView.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(p0: String?): Boolean {
                medicamentViewModel.getMedicamentByName(p0 + "%")
                    .observe(requireActivity(), Observer {
                        if(it.isEmpty()){
                            binding.oops.text = Constants.OOPS[Random().nextInt(Constants.OOPS.size)]
                            binding.oopsText.setText(R.string.OOPS)
                            binding.oopsText.visibility = View.VISIBLE;
                            binding.oops.visibility = View.VISIBLE;
                        }else{
                            binding.oopsText.visibility = View.GONE;
                            binding.oops.visibility = View.GONE;
                        }
                        medicamentList.clear()
                        medicamentList.addAll(it)
                        adapter.notifyDataSetChanged()
                    })
                return true
            }

        })
//        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//            override fun onQueryTextChange(newText: String?): Boolean {
//                medicamentViewModel.getMedicamentByName(newText + "%")
//                    .observe(requireActivity(), Observer {
//                        medicamentList.clear()
//                        medicamentList.addAll(it)
//                        adapter.notifyDataSetChanged()
//                    })
//                return true
//            }
//        })



        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = SearchFragment()
    }


}