package com.miu.problem2

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.text.DecimalFormat

class ProductAdapter(
    var blist: ArrayList<Product>,
    private val listener: OnProductItemClickListener,
    private val addListener: OnProductAddClickListener
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(
        itemView: View,
        private val listener: OnProductItemClickListener,
        private val addListener: OnProductAddClickListener
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var imgView: ImageView
        var tvProductName: TextView
        var tvProductDescription: TextView
        var tvPrice: TextView
        var btnAdd: Button
        var imLogo:ImageView

        init {
            imgView = itemView.findViewById(R.id.ivProductIcon)
            tvProductName = itemView.findViewById(R.id.tvProductName)
            tvProductDescription = itemView.findViewById((R.id.tvProductDescription))
            tvPrice = itemView.findViewById(R.id.tvPrice)
            btnAdd = itemView.findViewById(R.id.btnAdd)
            imLogo=itemView.findViewById(R.id.logo)
            itemView.setOnClickListener(this)
            btnAdd.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    addListener.onButtonClick(position)
                }
            }
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnProductItemClickListener {
        fun onItemClick(position: Int)
    }

    interface OnProductAddClickListener {
        fun onButtonClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ProductViewHolder(view, listener, addListener)
    }

    override fun getItemCount(): Int {
        return blist.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var item = blist[position]
        holder.tvProductName.text = item.productName
        holder.tvProductDescription.text = item.productDescription
        val price = String.format("%.2f", item.cost)
        holder.tvPrice.text = "$ $price"
        var icon = resolveIcon(item.productName)
        holder.imgView.setImageResource(icon.productIcon)
        holder.imLogo.setImageResource((icon.productLogo))
    }

    companion object {
        public fun resolveIcon(item: String): ProductImage {
            if (item.lowercase().contains("ipad"))
                return ProductImage(R.drawable.ipad, R.drawable.apple_logo)
            else if (item.lowercase().contains("mac"))
                return ProductImage(R.drawable.mac, R.drawable.apple_logo)
            else if (item.lowercase().contains("dell"))
                return ProductImage(R.drawable.dell, R.drawable.dell_logo)
            else if (item.lowercase().contains("logitech"))
                return ProductImage(R.drawable.logitech, R.drawable.logitech_logo)
            else
                throw Exception("Icon can't be resolved")
        }
    }
}