package ec.edu.espoch.aplicativo.user.presenter

interface LoginContract {

    interface View {
        fun mostrarMensajeExito(mensaje: String)
        fun mostrarMensajeError(mensaje: String)
    }

    interface Presenter {
        fun login(correo: String, password: String)
    }
}
