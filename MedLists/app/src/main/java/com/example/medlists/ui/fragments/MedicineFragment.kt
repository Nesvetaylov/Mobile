package com.example.medlists.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medlists.databinding.FragmentMedicineBinding
import com.example.medlists.model.Medicine
import com.example.medlists.ui.adapter.MedicineAdapter

class MedicineFragment : Fragment() {

    private var _binding: FragmentMedicineBinding? = null
    private val binding get() = _binding!!

    private val sampleData = listOf(
        Medicine("Парацетамол", "Обезболивающее и жаропонижающее"),
        Medicine("Ибупрофен", "Противовоспалительное средство"),
        Medicine("Амоксициллин", "Антибиотик широкого спектра действия")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedicineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvMedicine.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMedicine.adapter = MedicineAdapter(sampleData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
