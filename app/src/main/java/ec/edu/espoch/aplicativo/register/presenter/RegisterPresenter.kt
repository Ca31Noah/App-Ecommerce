package ec.edu.espoch.aplicativo.register.presenter

import ec.edu.espoch.aplicativo.register.RegisterContract
import ec.edu.espoch.aplicativo.register.Usuario
import ec.edu.espoch.aplicativo.register.data.RegisterInteractor

class RegisterPresenter(private val interactor: RegisterInteractor) : RegisterContract.Presenter {

    override fun agregarUsuario(usuario: Usuario) {
        interactor.agregarUsuario(usuario)
    }

    override fun setView(view: RegisterContract.View) {
        interactor.setView(view)
    }
}
