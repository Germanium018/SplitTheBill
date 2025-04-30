package com.android.splitthebill

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.android.splitthebill.model.BillingItem

class BillingListAdapter(
    private val context: Context,
    private val billingList: MutableList<BillingItem>
) : BaseAdapter() {

    override fun getCount(): Int = billingList.size

    override fun getItem(position: Int): Any = billingList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = billingList[position]
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_billing, parent, false)

        val title = view.findViewById<TextView>(R.id.textview_title)
        val date = view.findViewById<TextView>(R.id.date)
        val amount = view.findViewById<TextView>(R.id.textview_totalAmount)

        title.text = item.title
        date.text = item.date
        amount.text = "Php %.2f".format(item.amount)

        return view
    }

    fun updateData(newItems: List<BillingItem>) {
        billingList.clear()
        billingList.addAll(newItems)
        notifyDataSetChanged()
    }
}
