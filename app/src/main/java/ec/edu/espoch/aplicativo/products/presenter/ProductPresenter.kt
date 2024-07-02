package ec.edu.espoch.aplicativo.products.presenter

import ec.edu.espoch.aplicativo.products.ProductsContract
import ec.edu.espoch.aplicativo.products.view.ProductView

class ProductPresenter(private val view: ProductView, private val interactor: ProductsContract.Interactor) : ProductsContract.Presenter {

    override fun loadProducts() {
        interactor.getProducts { products ->
            if (products.isNotEmpty()) {
                view.showProducts(products)
            } else {
                view.showError("No products found")
            }
        }
    }

    override fun loadProductsByCompany(companyId: Int) {
        interactor.getProductsByCompany(companyId) { products ->
            if (products.isNotEmpty()) {
                view.showProducts(products)
            } else {
                view.showError("No products found for company ID $companyId")
            }
        }
    }
}
