package com.sebastian.project.ui.principal.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sebastian.project.R
import com.sebastian.project.core.Constantes
import com.sebastian.project.data.EventsData
import com.sebastian.project.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var eventsAdapter: EventsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        initUI()

    }

    private fun initUI() {
        eventsAdapter = EventsAdapter(details = { details(it) })
        initList()
        loadData()
    }

    private fun details(data: EventsData) {
        val action = HomeFragmentDirections.actionNavigationHomeToEventFragment(data.id)
        findNavController().navigate(action)
    }

    private fun initList() {
        binding.rcvEvent.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = eventsAdapter
        }
    }

    private fun loadData() {
        binding.apply {

            toolbar.apply {
                txtTitle.setText(R.string.titleHome)
                txtDescription.setText(R.string.descriptionHome)
            }

            eventsAdapter.update(Constantes.data)

        }
    }
}