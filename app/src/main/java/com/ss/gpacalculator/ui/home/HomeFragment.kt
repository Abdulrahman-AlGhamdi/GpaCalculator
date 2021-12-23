package com.ss.gpacalculator.ui.home

import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils.loadAnimation
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ss.gpacalculator.R
import com.ss.gpacalculator.databinding.FragmentHomeBinding
import com.ss.gpacalculator.utils.navigateTo
import com.ss.gpacalculator.utils.viewBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        navigateTo()
    }

    private fun init() {
        setHasOptionsMenu(true)
        binding.message.text = getString(R.string.message, String(Character.toChars(0x2764)))
        val appearAnimation = loadAnimation(requireContext(), R.anim.appear_animation)
        val bottomAnimation = loadAnimation(requireContext(), R.anim.animation_from_button)
        binding.logo.animation = appearAnimation
        binding.totalCalculate.animation = bottomAnimation
        binding.semesterCalculate.animation = bottomAnimation

        val vectorDrawable = binding.logo.drawable as AnimatedVectorDrawable
        vectorDrawable.start()
        vectorDrawable.registerAnimationCallback(object : Animatable2.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                vectorDrawable.start()
            }
        })
    }

    private fun navigateTo() {
        binding.semesterCalculate.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToSemesterCalculateFragment()
            findNavController().navigateTo(action, R.id.homeFragment)
        }

        binding.totalCalculate.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTotalCalculateFragment()
            findNavController().navigateTo(action, R.id.homeFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.settings) {
            val action = HomeFragmentDirections.actionHomeFragmentToSettingsFragment()
            findNavController().navigateTo(action, R.id.homeFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}