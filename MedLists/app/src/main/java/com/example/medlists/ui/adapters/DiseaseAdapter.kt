package com.example.medlists.ui.adapters  // проверь, что название папки именно adapters, а не adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medlists.R
import com.example.medlists.model.Disease
class DiseaseAdapter(private val items: List<Disease>) :
    RecyclerView.Adapter<DiseaseAdapter.DiseaseViewHolder>() {

    class DiseaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tvDiseaseName)
        val descriptionTextView: TextView = itemView.findViewById(R.id.tvDiseaseDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiseaseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_disease, parent, false)
        return DiseaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiseaseViewHolder, position: Int) {
        val disease = items[position]
        holder.nameTextView.text = disease.name
        holder.descriptionTextView.text = disease.description
    }

    override fun getItemCount(): Int = items.size
}
