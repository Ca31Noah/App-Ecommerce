package ec.edu.espoch.aplicativo.login.presenter

import ec.edu.espoch.aplicativo.login.LoginContract
import ec.edu.espoch.aplicativo.login.data.LoginInteractor

class LoginPresenter(private val interactor: LoginInteractor) : LoginContract.Presenter, LoginContract.OnResponseCallBack {

    private lateinit var view: LoginContract.View

    override fun login(correo: String, password: String) {
        view.showLoader()
        interactor.login(correo, password)
    }

    override fun onResponseSuccess() {
        view.hideLoader()
        view.mostrarMensajeExito("¡Inicio de sesión exitoso!")
        view.navigateToMain()
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
