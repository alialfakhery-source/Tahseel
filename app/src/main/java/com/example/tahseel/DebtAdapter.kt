package com.example.tahseel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DebtAdapter(private var debtList: List<Debt>) : RecyclerView.Adapter<DebtAdapter.DebtViewHolder>() {

    class DebtViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewAmount: TextView = itemView.findViewById(R.id.textViewAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DebtViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_debt, parent, false)
        return DebtViewHolder(view)
    }

    override fun onBindViewHolder(holder: DebtViewHolder, position: Int) {
        val debt = debtList[position]
        holder.textViewName.text = debt.name
        holder.textViewAmount.text = debt.amount.toString()
    }

    override fun getItemCount(): Int = debtList.size

    fun updateDebts(newDebts: List<Debt>) {
        debtList = newDebts
        notifyDataSetChanged()
    }
}
