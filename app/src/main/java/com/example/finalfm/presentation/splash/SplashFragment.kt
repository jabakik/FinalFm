package com.example.finalfm.presentation.splash

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalfm.databinding.FragmentFmSplashBinding

class SplashFragment: Fragment() {
    private var _binding: FragmentFmSplashBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFmSplashBinding.inflate(inflater, container, false)
        return binding.root
     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animateLogo()
    }
    private fun animateLogo () {
        val logoAnimator = ValueAnimator.ofFloat(0f,1f).apply {
            duration = 2000L
            interpolator = AccelerateInterpolator()
        }
        logoAnimator.addUpdateListener {
            val animatedValue = it.animatedValue as Float
            binding.fmLogo.alpha = animatedValue
            val scaleFraction = 2 - (1- animatedValue)
            binding.fmLogo.scaleX = scaleFraction
            binding.fmLogo.scaleY = scaleFraction
        }
        logoAnimator.addListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                goToLoginFragment ()

            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationRepeat(p0: Animator?) {

            }

        })
        logoAnimator.start()
    }
    fun goToLoginFragment(){
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}