package ec.edu.espoch.aplicativo.user.presenter

import ec.edu.espoch.aplicativo.user.LoginContract
import ec.edu.espoch.aplicativo.user.data.LoginInteractor

class LoginPresenter(private val interactor: LoginInteractor) : LoginContract.Presenter {

    private lateinit var view: LoginContract.View

    override fun login(correo: String, password: String) {
        interactor.login(correo, password)
    }

    fun setView(view: LoginContract.View) {
        this.view = view
        interactor.setView(view)
    }
}
