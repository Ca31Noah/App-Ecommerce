package ec.edu.espoch.aplicativo.user.presenter

import ec.edu.espoch.aplicativo.user.RegisterContract
import ec.edu.espoch.aplicativo.user.Usuario
import ec.edu.espoch.aplicativo.user.data.RegisterInteractor

class RegisterPresenter(private val interactor: RegisterInteractor) : RegisterContract.Presenter {

    override fun agregarUsuario(usuario: Usuario) {
        interactor.agregarUsuario(usuario)
    }

    override fun setView(view: RegisterContract.View) {
        interactor.setView(view)
    }
}
