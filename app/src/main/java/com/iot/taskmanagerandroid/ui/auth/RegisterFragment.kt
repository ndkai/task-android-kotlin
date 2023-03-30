package com.iot.taskmanagerandroid.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.iot.taskmanagerandroid.R
import com.iot.taskmanagerandroid.databinding.FragmentLoginBinding
import com.iot.taskmanagerandroid.databinding.FragmentRegisterBinding
import com.iot.taskmanagerandroid.utils.SharePreferenceHelper
import javax.inject.Inject

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    @Inject
    lateinit var prefs: SharePreferenceHelper

    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}