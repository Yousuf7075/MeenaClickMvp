package com.example.meenaclickmvp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apiretrofitdemo.Utils.Constant
import com.example.meenaclickmvp.R
import com.example.meenaclickmvp.model.CatalogProductsItem
import com.example.meenaclickmvp.ui.MainContract.Communicator
import kotlinx.android.synthetic.main.home_item_row.view.*


class HomeAdapter(
    private val list: ArrayList<CatalogProductsItem>, private val context: HomeFragment ):
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    var count = 0
    var cartValue = 0

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image = itemView.tv_image
        val productName = itemView.tv_name
        val productClass = itemView.tv_weight
        val price = itemView.tv_price

        //click item
        val add_to_bag_bt  = itemView.tv_add_to_cart
        val plus_quantity_bt = itemView.bt_increase
        val minus_quantity_bt = itemView.bt_decrease
        val quantity_display = itemView.tv_in_cart_quantity
        val delete_bt = itemView.bt_delete

        val item = itemView.upper_container_cl

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.home_item_row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weight_txt = "[ "+ list.get(position).weight + list.get(position).weightClass + " ]"
        Glide.with(context).load(Constant.IMAGE_BASE_URL+list.get(position).productImage).into(holder.image)
        holder.productName.text = list.get(position).productName
        holder.productClass.text = weight_txt
        holder.price.text = list.get(position).price.toString()

        //when click on add to bag
        holder.add_to_bag_bt.setOnClickListener {
            holder.add_to_bag_bt.visibility = View.GONE
            count = 1
            holder.quantity_display.text = count.toString()
            holder.delete_bt.visibility = View.VISIBLE
            holder.quantity_display.visibility = View.VISIBLE
            cartValue ++
        }

        //when click on plus btn
        holder.plus_quantity_bt.setOnClickListener {
            count ++
            /*holder.quantity_display.visibility = View.VISIBLE
            holder.add_to_bag_bt.visibility = View.GONE*/

            if(count == 1){
                holder.delete_bt.visibility = View.GONE
                holder.minus_quantity_bt.visibility = View.VISIBLE
            }
            holder.quantity_display.text = count.toString()
        }

        //when click on minus btn
        holder.minus_quantity_bt.setOnClickListener {
            if (count > 1){
                count --
                holder.quantity_display.text = count.toString()
            }
            if (count == 1){
                holder.add_to_bag_bt.visibility = View.VISIBLE
                holder.quantity_display.visibility = View.GONE
                holder.minus_quantity_bt.visibility = View.GONE
            }
        }

        //when click on delete btn
        holder.delete_bt.setOnClickListener {
            holder.add_to_bag_bt.visibility = View.VISIBLE
            holder.delete_bt.visibility = View.GONE
            holder.quantity_display.visibility = View.GONE
        }


        //when click on item
        holder.item.setOnClickListener {
            /*val name  = list.get(position).productName*/
        }


    }

}