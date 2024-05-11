package com.example.bmicalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoppingListAdapter(private val items: List<String>) :
        RecyclerView.Adapter<ShoppingListAdapter.ItemViewHolder>() {
            inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                val itemName: TextView = itemView.findViewById(R.id.itemName)
                val checkBox: CheckBox = itemView.findViewById(R.id.cbDone)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.shopping_list_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentIngredient = items[position]
        holder.itemName.text = currentIngredient

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                holder.itemName.strikeThrough()
            } else {
                holder.itemName.removeStrikeThrough()
            }
        }
    }

    override fun getItemCount() = items.size
}

fun TextView.strikeThrough() {
    this.paintFlags = this.paintFlags or android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
}

fun TextView.removeStrikeThrough() {
    this.paintFlags = this.paintFlags and android.graphics.Paint.STRIKE_THRU_TEXT_FLAG.inv()
}