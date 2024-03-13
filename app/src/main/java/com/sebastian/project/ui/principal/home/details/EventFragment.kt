package com.sebastian.project.ui.principal.home.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.sebastian.project.R
import com.sebastian.project.core.Constantes
import com.sebastian.project.databinding.FragmentEventBinding

class EventFragment : Fragment(R.layout.fragment_event) {

   private lateinit var binding: FragmentEventBinding
   private val arg by navArgs<EventFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEventBinding.bind(view)

        initUI()

    }

    private fun initUI() {
        loadData()
    }

    private fun loadData() {
        val result = Constantes.data.find {
            it.id == arg.id
        }

        binding.apply {
            toolbar.apply {
                txtTitle.text = result?.title
                txtDescription.setText(R.string.descriptionDetailsToolbar)
            }
        }


    }

}