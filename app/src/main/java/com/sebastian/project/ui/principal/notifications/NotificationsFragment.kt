package com.sebastian.project.ui.principal.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sebastian.project.R
import com.sebastian.project.core.Constantes
import com.sebastian.project.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {

    private lateinit var binding: FragmentNotificationsBinding
    private lateinit var notificationsAdapter: NotificationsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotificationsBinding.bind(view)


        initUI()



    }

    private fun initUI() {
        notificationsAdapter = NotificationsAdapter()
        loadList()
        loadData()
    }

    private fun loadList() {
        binding.rcvNotifications.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = notificationsAdapter
        }
    }

    private fun loadData() {

        val dataFilter = Constantes.data.filter {
            it.alert
        }

        binding.apply {

            toolbar.apply {
                txtTitle.setText(R.string.titleNotification)
                txtDescription.setText(R.string.descriptionNotification)
            }


            notificationsAdapter.update(dataFilter)


        }
    }
}