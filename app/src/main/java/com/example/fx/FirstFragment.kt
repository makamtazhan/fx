package com.example.fx

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_first.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.FieldPosition

class FirstFragment : Fragment() {
    lateinit var list: MutableList<Country>
    private lateinit var MyRecyclerView: RecyclerView
    private lateinit var viewAdapter: Adapter
    private lateinit var viewManager: LinearLayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_first, container,false)
        list = ArrayList()
        myRecyclerView = rootView.findViewById(R.id.myRecyclerView)
        viewManager = LinearLayoutManager(context)
        myRecyclerView.LayoutManager = viewManager
        val dividerItemDecoration = DividerItemDecoration(
            myRecyclerView.context,
            viewManager.orientation
        )
        myRecyclerView.addItemDecoration(dividerItemDecoration)
        viewAdapter = context?.let {Adapter(list, it, this)} !!
        myRecyclerView.adapter = viewAdapter
        viewAdapter.notifyDataSetChanged()
        getList()
        return rootView
    }

    private fun getList(){
        val list = ArrayList<Country>()
        ApiClient.getApiService().getCountries().enqueue(object : Callback<List<Country>>{
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                list.addAll(response.body()!!)
                viewAdapter.list = list
                viewAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Toast.makeText(context, "error", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun itemClick(position: Int, item: Country?){
        val bundle = Bundle()
        bundle.putString("slug", item?.slug)
        view?.findNavController()?.navigate(R.id.secondFragment, bundle)
    }
}