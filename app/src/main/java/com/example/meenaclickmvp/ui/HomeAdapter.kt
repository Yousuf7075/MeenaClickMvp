package com.example.meenaclickmvp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apiretrofitdemo.Utils.Constant
import com.example.meenaclickmvp.R
import com.example.meenaclickmvp.model.CatalogProductsItem
import kotlinx.android.synthetic.main.each_item_design.view.*

class HomeAdapter(val list: ArrayList<CatalogProductsItem>, val context: HomeFragment):
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image = itemView.itemIV
        val productName = itemView.nameTV
        val productClass = itemView.classTV
        val price = itemView.priceTV
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.each_item_design, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(Constant.IMAGE_BASE_URL+list.get(position).productImage).into(holder.image)
        holder.productName.text = list.get(position).productName
        holder.productClass.text = list.get(position).weightClass
        holder.price.text = list.get(position).price.toString()
    }
}