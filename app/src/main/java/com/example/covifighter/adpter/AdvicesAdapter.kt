package com.example.covifighter.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covifighter.R
import com.example.covifighter.models.Container
import kotlinx.android.synthetic.main.shape_item.view.*

class AdvicesAdapter(private val items:List<Container>):RecyclerView.Adapter<AdvicesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.shape_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items.get(position)
        holder.image.setImageResource(data.imageResourses)
        holder.text.setText(data.title)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val text= itemView.text
        val image=itemView.image

    }

}