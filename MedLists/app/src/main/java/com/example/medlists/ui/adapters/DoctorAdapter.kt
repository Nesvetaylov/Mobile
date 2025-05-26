package com.example.medlists.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medlists.R
import com.example.medlists.model.Doctor

class DoctorAdapter(private val items: List<Doctor>) :
    RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tvDoctorName)
        val specialtyTextView: TextView = itemView.findViewById(R.id.tvDoctorSpecialty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doctor, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doctor = items[position]
        holder.nameTextView.text = doctor.name
        holder.specialtyTextView.text = doctor.specialty
    }

    override fun getItemCount(): Int = items.size
}
