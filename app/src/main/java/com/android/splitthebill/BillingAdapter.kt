package com.android.splitthebill

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BillingAdapter(private val billingList: MutableList<BillingItem>) :
    RecyclerView.Adapter<BillingAdapter.BillingViewHolder>() {

    class BillingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.textview_title)
        val date: TextView = itemView.findViewById(R.id.date)
        val amount: TextView = itemView.findViewById(R.id.textview_totalAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BillingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_billing, parent, false)
        return BillingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BillingViewHolder, position: Int) {
        val item = billingList[position]
        holder.title.text = item.title
        holder.date.text = item.date
        holder.amount.text = "Php ${"%.2f".format(item.amount)}"
    }

    override fun getItemCount(): Int = billingList.size

    fun updateData(newItems: List<BillingItem>) {
        billingList.clear()
        billingList.addAll(newItems)
        notifyDataSetChanged()
    }
}

