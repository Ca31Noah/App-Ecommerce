package ec.edu.espoch.aplicativo.cantones.presenter

import ec.edu.espoch.aplicativo.cantones.CantonesContract
import ec.edu.espoch.aplicativo.cantones.data.CantonInteractor

class CantonesPresenter(private val view: CantonesContract.View) : CantonesContract.Presenter {

    private val interactor = CantonInteractor()

    override fun loadCantones() {
        view.showLoader()
        interactor.getCantones { cantones ->
            view.hideLoader()
            view.showCantones(cantones)
        }
    }
}
