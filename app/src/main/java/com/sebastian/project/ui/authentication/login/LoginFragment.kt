package com.sebastian.project.ui.authentication.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.sebastian.project.R
import com.sebastian.project.databinding.FragmentLoginBinding
import com.sebastian.project.ui.principal.HomeActivity

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)


        initUI()

    }

    private fun initUI() {
        loadData()
        setupListener()
    }

    private fun loadData() {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.grayMin)
    }

    private fun setupListener() {
        binding.apply {

            btnGoEmail.setOnClickListener {
                startActivity(Intent(requireContext(), HomeActivity::class.java))
            }

            btnGoPhone.setOnClickListener {
                startActivity(Intent(requireContext(), HomeActivity::class.java))
            }

        }
    }


}