package ec.edu.espoch.aplicativo.products.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.products.Product

class ProductAdapter : ListAdapter<Product, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.productName)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.productDescription)
        private val priceTextView: TextView = itemView.findViewById(R.id.productPrice)
        private val productImageView: ImageView = itemView.findViewById(R.id.productImage)

        fun bind(product: Product) {
            nameTextView.text = product.Nombre
            descriptionTextView.text = product.Descripcion
            priceTextView.text = product.Precio.toString()

            // Cargar la imagen desde la URL usando Glide
            Glide.with(itemView.context)
                .load(product.imagenUrl)
                .into(productImageView)
        }
    }

    class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id_pro_ser == newItem.id_pro_ser
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}
