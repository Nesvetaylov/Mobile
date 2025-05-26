package com.example.medlists.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medlists.databinding.FragmentDiseaseBinding
import com.example.medlists.model.Disease
import com.example.medlists.ui.adapters.DiseaseAdapter

class DiseaseFragment : Fragment() {

    private var _binding: FragmentDiseaseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDiseaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val testDiseases = listOf(
            Disease("Грипп", "Вирусное инфекционное заболевание"),
            Disease("Диабет", "Хроническое заболевание, связанное с уровнем сахара в крови"),
            Disease("Астма", "Хроническое воспалительное заболевание дыхательных путей")
        )

        val adapter = DiseaseAdapter(testDiseases)
        binding.recyclerViewDisease.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewDisease.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

