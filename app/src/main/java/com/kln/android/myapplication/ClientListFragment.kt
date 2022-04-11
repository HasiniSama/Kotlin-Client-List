package com.kln.android.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kln.android.myapplication.adapter.ClientListAdapter
import com.kln.android.myapplication.database.AppDatabase
import com.kln.android.myapplication.databinding.FragmentFirstBinding
import com.kln.android.myapplication.model.Client

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ClientListFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //creating the room database connection
        val db = AppDatabase.getDatabase(view.context)
        val clientDao = db.clientDao()

        // getting the recyclerview by its id
        val recyclerview = binding.recyclerview

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(activity)

        // ArrayList of class ItemsViewModel
        val data = clientDao.getAll()

        // This will pass the ArrayList to our Adapter
        val adapter = ClientListAdapter(data, requireActivity().parent)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}