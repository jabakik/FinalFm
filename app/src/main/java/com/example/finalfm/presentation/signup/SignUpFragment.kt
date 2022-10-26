package com.example.finalfm.presentation.signup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalfm.databinding.FragmentFmSignupBinding
import com.example.finalfm.presentation.login.LoginFragment
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment: Fragment() {
    private var _binding: FragmentFmSignupBinding? = null
    private val binding get() = _binding!!
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFmSignupBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.fmSignUpButton.setOnClickListener {
            val email = binding.fmEnterEmail.text.toString()
            val pass = binding.fmEnterPassword.text.toString()
            val passcon = binding.fmReEnterPassword.text.toString()
            if (email.isNotEmpty() && pass.isNotEmpty() && passcon.isNotEmpty()) {
                if (pass == passcon) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            goToLoginFragment()
                        }
                    }
                }
            }
        }
    }
    private fun goToLoginFragment() {
        findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToLoginFragment())
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}













