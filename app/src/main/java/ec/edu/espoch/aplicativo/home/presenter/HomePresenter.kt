package ec.edu.espoch.aplicativo.home.presenter

import ec.edu.espoch.aplicativo.HomeContract
import ec.edu.espoch.aplicativo.home.data.HomeInteractor

class HomePresenter(
    private val view: HomeContract.View,
    private val interactor: HomeInteractor
) : HomeContract.Presenter {

    override fun searchProducts(query: String) {
        view.showLoading()
        interactor.buscarProductos(query) { productos, error ->
            view.hideLoading()
            if (error != null) {
                view.displayError(error)
            } else {
                if (productos != null) {
                    view.displayProducts(productos)
                } else {
                    view.displayError("No se encontraron productos.")
                }
            }
        }
    }

    override fun fetchAllProducts() {
        view.showLoading()
        interactor.listarTodosLosProductos { productos, error ->
            view.hideLoading()
            if (error != null) {
                view.displayError(error)
            } else {
                if (productos != null) {
                    view.displayProducts(productos)
                } else {
                    view.displayError("No se encontraron productos.")
                }
            }
        }
    }

    override fun fetchBestSellingProducts() {
        view.showLoading()
        interactor.listarProductosMasVendidos { productos, error ->
            view.hideLoading()
            if (error != null) {
                view.displayError(error)
            } else {
                if (productos != null) {
                    view.displayBestSellingProducts(productos)
                } else {
                    view.displayError("No se encontraron productos más vendidos.")
                }
            }
        }
    }

    override fun onDestroy() {
        // Implementar para liberar recursos si es necesario
    }
}
