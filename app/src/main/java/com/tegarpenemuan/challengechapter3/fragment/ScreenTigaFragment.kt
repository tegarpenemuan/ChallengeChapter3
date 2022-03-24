package com.tegarpenemuan.challengechapter3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.tegarpenemuan.challengechapter3.R
import com.tegarpenemuan.challengechapter3.databinding.FragmentScreenTigaBinding
import com.tegarpenemuan.challengechapter3.model.Person

class ScreenTigaFragment : Fragment() {

    private var _binding: FragmentScreenTigaBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<ScreenTigaFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScreenTigaBinding.inflate(inflater, container, false)
        val view = binding.root

        val nama = args.showData.nama
        val usia = args.showData.usia
        if (usia != null) {
            val GanjilGenap = GanjilGenap(usia)

            binding.tvShowData.text =
                "${args.showData.nama}\n" +
                        "Umur ${usia} Tahun, bernilai ${GanjilGenap}\n" +
                        "${args.showData.alamat}\n" +
                        "${args.showData.pekerjaan}"
        } else {
            val usia = ""

            binding.tvShowData.text =
                "${args.showData.nama}\n" +
                        "${usia}\n" +
                        "${args.showData.alamat}\n" +
                        "${args.showData.pekerjaan}"
        }

        binding.btnToScreen4.setOnClickListener {
            val action =
                ScreenTigaFragmentDirections.actionScreenTigaFragmentToScreenEmpatFragment(nama.toString())
            view.findNavController().navigate(action)
        }

        return view
    }

    fun GanjilGenap(usia: Int): String {
        if (usia % 2 == 0)
            return "Genap"
        else
            return "Ganjil"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}