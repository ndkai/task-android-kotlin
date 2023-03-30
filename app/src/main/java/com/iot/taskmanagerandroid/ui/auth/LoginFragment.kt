package com.iot.taskmanagerandroid.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.iot.taskmanagerandroid.R
import com.iot.taskmanagerandroid.databinding.FragmentHomeBinding
import com.iot.taskmanagerandroid.databinding.FragmentLoginBinding
import com.iot.taskmanagerandroid.ui.BaseFragment
import com.iot.taskmanagerandroid.utils.SharePreferenceHelper
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment() {

    private lateinit var binding: FragmentLoginBinding

    @Inject
    lateinit var prefs: SharePreferenceHelper

    private val viewModel by viewModels<LoginViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        observeViewModels()
        binding.viewModel = viewModel
       try{
           var login = prefs.getLoginResponse()
           if(login != null){
               val current = LocalDateTime.now()
               if(login.dateExpired.compareTo(current) > 0 ){
                   findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
               }  else {
//                   showShortSnackBar("Phiên đăng nhập hết hạn")
               }
           }
       } catch(e: Exception){}
//        binding.signupButton.setOnClickListener {
//            findNavController().navigate(R.id.action_loginFragment_to_SignupFragment)
//        }
//        binding.button.setOnClickListener {
//            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
//        }
    }

    private fun observeViewModels(){
        with(viewModel){
            loginResponse.observe(viewLifecycleOwner) {
                login ->
                login?.let {
                    prefs.saveLoginResponse(login)
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                }
            }

            isLoading.observe(viewLifecycleOwner) {
                state -> when(state) {
                    true -> {
                        hideLoginView()
                    }
                    false -> {
                        showLoginView()
                    }
            }
            }
        }
    }

    private fun hideLoginView(){
        binding.apply {
            button.visibility = View.GONE
            textInputLayout2.visibility = View.GONE
            textInputLayout1.visibility = View.GONE
            textInputLayout1.visibility = View.GONE
            loading.visibility = View.VISIBLE
        }
    }

    private fun showLoginView(){
        binding.apply {
            button.visibility = View.VISIBLE
            textInputLayout2.visibility = View.VISIBLE
            textInputLayout1.visibility = View.VISIBLE
            loading.visibility = View.GONE
        }
    }

}