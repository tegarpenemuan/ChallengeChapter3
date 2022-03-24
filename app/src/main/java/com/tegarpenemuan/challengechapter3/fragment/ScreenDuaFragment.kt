package com.tegarpenemuan.challengechapter3.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.tegarpenemuan.challengechapter3.databinding.FragmentScreenDuaBinding
import com.tegarpenemuan.challengechapter3.model.Person


class ScreenDuaFragment : Fragment() {

    private var _binding: FragmentScreenDuaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScreenDuaBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.btnToScreen3.setOnClickListener {

            if(binding.etNama.text.isEmpty()) {
                binding.etNama.error = "Kolom Nama tidak boleh kosong"
                binding.etNama.requestFocus()
                return@setOnClickListener
            }

            val nama = binding.etNama.text.toString()
            val person = Person(nama,null,"","")

            val action = ScreenDuaFragmentDirections.actionScreenDuaFragmentToScreenTigaFragment(person)
            view.findNavController().navigate(action)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}