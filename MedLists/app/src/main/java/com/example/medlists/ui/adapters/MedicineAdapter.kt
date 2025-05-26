package com.example.medlists.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medlists.R
import com.example.medlists.model.Medicine

class MedicineAdapter(private val items: List<Medicine>) :
    RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder>() {

    class MedicineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tvMedicineName)
        val descriptionTextView: TextView = itemView.findViewById(R.id.tvMedicineDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medicine, parent, false)
        return MedicineViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        val medicine = items[position]
        holder.nameTextView.text = medicine.name
        holder.descriptionTextView.text = medicine.description
    }

    override fun getItemCount(): Int = items.size
}
