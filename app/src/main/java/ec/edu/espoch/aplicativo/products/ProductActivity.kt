package ec.edu.espoch.aplicativo.products

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.products.data.ProductInteractor
import ec.edu.espoch.aplicativo.products.presenter.ProductPresenter
import ec.edu.espoch.aplicativo.products.view.ProductAdapter
import ec.edu.espoch.aplicativo.products.view.ProductView

class ProductActivity : AppCompatActivity(), ProductView {

    private lateinit var presenter: ProductPresenter
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ProductAdapter()
        recyclerView.adapter = adapter

        presenter = ProductPresenter(this, ProductInteractor())

        val companyId = intent.getIntExtra("COMPANY_ID", -1)
        if (companyId != -1) {
            presenter.loadProductsByCompany(companyId)
        } else {
            presenter.loadProducts()
        }
    }

    override fun showProducts(products: List<Product>) {
        adapter.submitList(products)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
