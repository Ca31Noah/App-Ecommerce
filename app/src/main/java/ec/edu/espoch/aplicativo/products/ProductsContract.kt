package ec.edu.espoch.aplicativo.products

interface ProductsContract {

    interface View {
        fun showProducts(products: List<Product>)
        fun showError(message: String)
    }

    interface Presenter {
        fun loadProducts()
    }

    interface Interactor {
        fun getProducts(callback: (List<Product>) -> Unit)
    }
}
