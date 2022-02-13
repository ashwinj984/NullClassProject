package com.projemanag.adapters

import android.content.Context
import android.graphics.Color
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.projemanag.R
import kotlinx.android.synthetic.main.item_label_color.view.*

class LabelColorListItemsAdapter(
    private val context: Context,
    private var list: ArrayList<String>,
    private val mSelectedColor: String
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var onItemsClickListener: onItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MemberListItemsAdapter.MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_label_color,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        if (holder is MyViewHolder) {
            holder.itemView.view_main.setBackgroundColor(Color.parseColor(item))
            if (item == mSelectedColor) {
                holder.itemView.iv_selected_color.visibility = View.VISIBLE
            } else {
                holder.itemView.iv_selected_color.visibility = View.GONE
            }

            holder.itemView.setOnClickListener {
                if (onItemsClickListener != null) {
                    onItemsClickListener!!.onCLick(position, item)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    interface onItemClickListener {
        fun onCLick(position: Int, coloe: String)
    }
}