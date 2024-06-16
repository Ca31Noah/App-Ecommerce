package ec.edu.espoch.aplicativo.cantones.presenter

import ec.edu.espoch.aplicativo.cantones.CantonesView
import ec.edu.espoch.aplicativo.cantones.data.CantonInteractor

class CantonesPresenter(private val view: CantonesView) {

    private val repository = CantonInteractor()

    fun cargarCantones() {
        repository.getCantones { cantones ->
            view.mostrarCantones(cantones)
        }
    }
}
