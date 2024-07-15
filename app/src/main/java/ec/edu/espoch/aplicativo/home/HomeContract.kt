package ec.edu.espoch.aplicativo

import ec.edu.espoch.aplicativo.products.Product

interface HomeContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun displayProducts(products: List<Product>)
        fun displayBestSellingProducts(products: List<Product>)
        fun displayError(message: String)
    }

    interface Presenter {
        fun searchProducts(query: String)
        fun fetchAllProducts()
        fun fetchBestSellingProducts()
        fun onDestroy()
    }

    interface Interactor {
        fun fetchProducts(query: String?, listener: OnFinishedListener)
        fun fetchBestSellingProducts(listener: OnFinishedListener)

        interface OnFinishedListener {
            fun onFinished(products: List<Product>)
            fun onFailure(t: Throwable)
        }
    }
}
