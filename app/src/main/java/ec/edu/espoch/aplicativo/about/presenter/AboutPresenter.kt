package ec.edu.espoch.aplicativo.about.presenter

import ec.edu.espoch.aplicativo.about.AboutContract
import ec.edu.espoch.aplicativo.about.model.AboutInteractor

class AboutPresenter(
    private val interactor: AboutInteractor,
    private val view: AboutContract.View
) : AboutContract.Presenter {

    override fun obtenerDatosUsuario() {
        val usuario = interactor.obtenerDatosUsuario()
        if (usuario != null) {
            view.mostrarDatosUsuario(usuario)
        } else {
            view.mostrarError("No se encontraron datos del usuario")
        }
    }
}
