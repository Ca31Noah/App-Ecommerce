package ec.edu.espoch.aplicativo.user.presenter

import ec.edu.espoch.aplicativo.user.LoginContract
import ec.edu.espoch.aplicativo.user.data.LoginInteractor

class LoginPresenter(private val interactor: LoginInteractor) : LoginContract.Presenter, LoginContract.OnResponseCallBack {

    private lateinit var view: LoginContract.View

    override fun login(correo: String, password: String) {
        view.showLoader()
        interactor.login(correo, password)
    }

    override fun onResponseSuccess() {
        view.hideLoader()
        view.mostrarMensajeExito("¡Inicio de sesión exitoso!")
    }

    override fun onResponseError(mensaje: String) {
        view.hideLoader()
        view.mostrarMensajeError(mensaje)
    }

    fun setView(view: LoginContract.View) {
        this.view = view
        interactor.setCallback(this)
    }
}
