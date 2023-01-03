package com.example1.projectapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example1.projectapp.databinding.FragmentWichListBinding


class WichListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : FragmentWichListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_wich_list, container, false);
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = WichListFragment()
    }
}