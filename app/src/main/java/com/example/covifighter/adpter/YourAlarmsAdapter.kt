package com.example.covifighter.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.covifighter.DataBase.Alarm
import com.example.covifighter.R
import kotlinx.android.synthetic.main.your_alarms_shape.view.*

class YourAlarmsAdapter (var items:List<Alarm>?):RecyclerView.Adapter<YourAlarmsAdapter.ViewHolder>() {
    //to change data
    fun changeData(items: List<Alarm>?){
        this.items=items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.your_alarms_shape,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val data=items?.get(position)
        holder.time.setText(data?.time)
        holder.address.setText(data?.description)

    }

    override fun getItemCount(): Int {
        return items?.size ?:0
    }

//   open fun removeItem(position: Int) {
//        items?.drop(position)
////        items.remove(position)
//        notifyDataSetChanged()
//    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener{
        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }
        val address=itemView.address
        val time = itemView.time
        override fun onLongClick(view: View): Boolean {
            Toast.makeText(view.context, "long click", Toast.LENGTH_SHORT).show()
     //       view.removeItem(5)
     //       itemView.deleteItem()

            // Return true to indicate the click was handled
            return true
        }
        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }
    }
}