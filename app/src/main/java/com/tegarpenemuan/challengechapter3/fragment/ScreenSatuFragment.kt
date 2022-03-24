package com.tegarpenemuan.challengechapter3.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import com.tegarpenemuan.challengechapter3.R
import com.tegarpenemuan.challengechapter3.databinding.FragmentScreenSatuBinding


class ScreenSatuFragment : Fragment() {

    private var _binding: FragmentScreenSatuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScreenSatuBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToScreen2.setOnClickListener {
            view.findNavController().navigate(R.id.screenDuaFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}