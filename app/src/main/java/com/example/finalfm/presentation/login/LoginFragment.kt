package com.example.finalfm.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalfm.databinding.FragmentFmLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment: Fragment() {
    private var _binding: FragmentFmLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFmLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.fmLoginButton.setOnClickListener{
            val email = binding.fmEnterEmail.text.toString()
            val pass = binding.fmEnterPassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToFmGenresFragment())
                    }
                }
            }

        }

        binding.fmSignupHere.setOnClickListener(){
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())

        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
