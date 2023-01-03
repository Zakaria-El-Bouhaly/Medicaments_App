package com.example1.projectapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example1.projectapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : FragmentSearchBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}