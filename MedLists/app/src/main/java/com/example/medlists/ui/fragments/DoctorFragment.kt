package com.example.medlists.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medlists.databinding.FragmentDoctorBinding
import com.example.medlists.model.Doctor
import com.example.medlists.ui.adapters.DoctorAdapter

class DoctorFragment : Fragment() {

    private var _binding: FragmentDoctorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDoctorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Тестовые данные
        val testDoctors = listOf(
            Doctor("Иван Иванов", "Терапевт"),
            Doctor("Мария Петрова", "Кардиолог"),
            Doctor("Алексей Сидоров", "Невролог")
        )

        val adapter = DoctorAdapter(testDoctors)
        binding.recyclerViewDoctor.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewDoctor.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
