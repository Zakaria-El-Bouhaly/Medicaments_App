package com.example1.projectapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        var recycle:RecyclerView = view.findViewById(R.id.recycleView)
        recycle.layoutManager = GridLayoutManager(context,2)
        var adapter = MedicamentAdapter()
        recycle.adapter = adapter
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}