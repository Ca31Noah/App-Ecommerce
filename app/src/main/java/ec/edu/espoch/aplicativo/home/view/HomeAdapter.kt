package ec.edu.espoch.aplicativo.home.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.products.Product

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ProductViewHolder>() {

    private var products: List<Product> = listOf()

    fun setProducts(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int = products.size

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
}
