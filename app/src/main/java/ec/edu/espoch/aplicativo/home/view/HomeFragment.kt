package ec.edu.espoch.aplicativo.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ec.edu.espoch.aplicativo.HomeContract
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.home.data.HomeInteractor
import ec.edu.espoch.aplicativo.home.presenter.HomePresenter
import ec.edu.espoch.aplicativo.products.Product

class HomeFragment : Fragment(), HomeContract.View {

    private lateinit var presenter: HomeContract.Presenter
    private lateinit var adapter: HomeAdapter
    private lateinit var bestSellingAdapter: HomeAdapter
    private lateinit var searchButton: Button
    private lateinit var searchEditText: EditText
    private lateinit var cartIcon: ImageView
    private lateinit var recyclerView: RecyclerView
    private lateinit var bestSellingRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        searchButton = view.findViewById(R.id.searchButton)
        searchEditText = view.findViewById(R.id.searchEditText)
        cartIcon = view.findViewById(R.id.cartIcon)
        recyclerView = view.findViewById(R.id.recyclerView)
        bestSellingRecyclerView = view.findViewById(R.id.bestSellingRecyclerView)

        presenter = HomePresenter(this, HomeInteractor())

        adapter = HomeAdapter()
        bestSellingAdapter = HomeAdapter()

        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        bestSellingRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        bestSellingRecyclerView.adapter = bestSellingAdapter

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            presenter.searchProducts(query)
        }

        cartIcon.setOnClickListener {
            // Aquí puedes manejar el clic en el icono del carrito de compras
            Toast.makeText(activity, "Carrito de compras", Toast.LENGTH_SHORT).show()
        }

        // Fetch all products on initial load
        presenter.fetchAllProducts()
        presenter.fetchBestSellingProducts()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun displayProducts(products: List<Product>) {
        adapter.setProducts(products)
    }

    override fun displayBestSellingProducts(products: List<Product>) {
        bestSellingAdapter.setProducts(products)
    }

    override fun displayError(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
