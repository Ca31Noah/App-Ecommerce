package ec.edu.espoch.aplicativo.user.presenter

import ec.edu.espoch.aplicativo.user.Usuario

interface RegisterContract {

    interface View {
        fun mostrarMensajeExito()
        fun mostrarMensajeError(error: String)
    }

    interface Presenter {
        fun agregarUsuario(usuario: Usuario)
        fun setView(view: View)
    }
}
