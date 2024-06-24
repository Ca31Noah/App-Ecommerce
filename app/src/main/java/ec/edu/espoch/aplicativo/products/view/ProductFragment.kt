package ec.edu.espoch.aplicativo.products.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.products.Product
import ec.edu.espoch.aplicativo.products.data.ProductInteractor
import ec.edu.espoch.aplicativo.products.presenter.ProductPresenter

class ProductFragment : Fragment(), ProductView {

    private lateinit var presenter: ProductPresenter
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = ProductAdapter()
        recyclerView.adapter = adapter

        presenter = ProductPresenter(this, ProductInteractor())
        presenter.loadProducts()

        return view
    }

    override fun showProducts(products: List<Product>) {
        adapter.submitList(products)
    }

    override fun showError(message: String) {
        Log.e("ProductFragment", "Error: $message")
        // Mostrar mensaje de error (puedes usar un Toast o un Snackbar)
    }
}
