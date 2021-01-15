package com.example.fx

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController


class SecondFragment : Fragment() {
    lateinit var list:MutableList<ApiResponse>
    var item: ApiResponse? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
    View? {
        val rootView = inflater.inflate(R.layout.fragment_second, container, false)
        list = ArrayList()
        rootView.back.setOnClickListener {
            val action = SecondFragmentDirections.actionDetailToMain()
            view?.findNavController()?.navigate(action)

        }
    }


}