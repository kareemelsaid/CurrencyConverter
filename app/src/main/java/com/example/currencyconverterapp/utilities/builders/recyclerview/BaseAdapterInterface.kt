package com.example.currencyconverterapp.utilities.builders.recyclerview

import android.view.View

interface BaseAdapterInterface {
    var viewItemsArrayList: ArrayList<AbstractViewItem>

    fun notifyDataSetChanged()
    fun notifyItemChanged(position: Int)
    fun notifyItemInserted(position: Int)
    fun notifyItemMoved(fromPosition: Int, toPosition: Int)
    fun notifyItemRemoved(position: Int)
    fun setOnItemClick(block: (itemView: View, model: ViewItemRepresentable?, position: Int) -> Unit)
    fun setOnItemLongClick(block: (itemView: View, model: ViewItemRepresentable?, position: Int) -> Unit)
    fun notifyItemRangeRemoved(positionStart: Int, itemCount: Int)
}