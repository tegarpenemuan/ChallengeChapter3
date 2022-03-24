package com.tegarpenemuan.challengechapter3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.tegarpenemuan.challengechapter3.R
import com.tegarpenemuan.challengechapter3.databinding.FragmentScreenEmpatBinding
import com.tegarpenemuan.challengechapter3.model.Person

class ScreenEmpatFragment : Fragment() {

    private var _binding: FragmentScreenEmpatBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<ScreenEmpatFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScreenEmpatBinding.inflate(inflater,container,false)
        val view = binding.root

        val nama = args.nama
        binding.btnBackToScreen3.setOnClickListener {

            if(binding.etUsia.text.isEmpty()) {
                binding.etUsia.error = "Kolom Usia tidak boleh kosong"
                binding.etUsia.requestFocus()
                return@setOnClickListener
            } else if(binding.etAlamat.text.isEmpty()) {
                binding.etAlamat.error = "Kolom Alamat tidak boleh kosong"
                binding.etAlamat.requestFocus()
                return@setOnClickListener
            } else if(binding.etPekerjaan.text.isEmpty()) {
                binding.etPekerjaan.error = "Kolom Pekerjaan tidak boleh kosong"
                binding.etPekerjaan.requestFocus()
                return@setOnClickListener
            }


            val usia = binding.etUsia.text.toString().toInt()
            val alamat = binding.etAlamat.text.toString()
            val pekerjaan = binding.etPekerjaan.text.toString()
            val person = Person(nama,usia,alamat,pekerjaan)

            val action = ScreenEmpatFragmentDirections.actionScreenEmpatFragmentToScreenTigaFragment(person)
            view.findNavController().navigate(action)
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}