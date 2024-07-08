package ec.edu.espoch.aplicativo.about.presenter

import ec.edu.espoch.aplicativo.about.AboutContract
import ec.edu.espoch.aplicativo.about.model.AboutInteractor

class AboutPresenter(
    private val interactor: AboutInteractor,
    private val view: AboutContract.View
) : AboutContract.Presenter, AboutContract.Interactor.OnFinishedListener {

    override fun obtenerPerfilUsuario(idUsuario: Int) {
        interactor.obtenerPerfilUsuario(idUsuario, this)
    }


    override fun onFinished(usuario: ec.edu.espoch.aplicativo.register.Usuario) {
        view.mostrarPerfilUsuario(usuario)
    }

    override fun onError(mensaje: String) {
        view.mostrarError(mensaje)
    }
}

