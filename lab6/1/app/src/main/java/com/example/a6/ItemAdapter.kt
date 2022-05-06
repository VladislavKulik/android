package com.example.a6

import android.content.Context
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(private val context: Context,
                  private val list: ArrayList<DataModel>,
                  private val cellClickListener: CellClickListener
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textValue: TextView = view.findViewById(R.id.textValue)
        val viewBackground: CardView = view.findViewById(R.id.view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.textValue.text = data.value
        holder.viewBackground.setCardBackgroundColor(data.color.toInt())

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(data)
        }
    }
    interface CellClickListener {
        fun onCellClickListener(data: DataModel)
    }
}