package com.example.surmarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.example.surmarket.models.product

class AdapterProducts(
    private val productsList: List<product>,
    private val clickOnBuy: (product)-> Unit
) : RecyclerView.Adapter<AdapterProducts.ViewHolderProducts>(
) {
    //==================
    class ViewHolderProducts(itemView: View): RecyclerView.ViewHolder(itemView){
        val TXT_ITProductList_Category: TextView= itemView.findViewById(R.id.TXT_ITProductList_Category)
        val TXT_ITProductList_Name: TextView= itemView.findViewById(R.id.TXT_ITProductList_Name)
        val TXT_ITProductList_Price: TextView= itemView.findViewById(R.id.TXT_ITProductList_Price)
        val BTN_ITProductList_Buy: Button= itemView.findViewById(R.id.BTN_ITProductList_Buy)
        val IMV_ITProductList_ProductImagen : ImageView= itemView.findViewById(R.id.IMV_ITProductList_ProductImagen)
        val stringCategory= itemView.context.getString(R.string.category)
        val stringPrice= itemView.context.getString(R.string.price)
    }
    //=================

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterProducts.ViewHolderProducts {
        val vista= LayoutInflater.from(parent.context).inflate( R.layout.item_productslist, parent, false)
        return ViewHolderProducts(itemView = vista)
    }

    override fun onBindViewHolder(
        holder: AdapterProducts.ViewHolderProducts, position: Int) {
        val product=productsList[position]
        holder.TXT_ITProductList_Category.text= holder.stringCategory + ": " + product.category
        holder.TXT_ITProductList_Name.text=product.name
        holder.TXT_ITProductList_Price.text=holder.stringPrice + ": " +"${product.price}"
        holder.IMV_ITProductList_ProductImagen.setImageResource(R.drawable.ic_surmarket)
        holder.BTN_ITProductList_Buy.setOnClickListener {
            clickOnBuy(product)
        }
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

}