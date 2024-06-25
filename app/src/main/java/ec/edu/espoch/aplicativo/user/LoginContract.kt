package ec.edu.espoch.aplicativo.user

interface LoginContract {

    interface View {
        fun mostrarMensajeExito(mensaje: String)
        fun mostrarMensajeError(mensaje: String)
    }

    interface Presenter {
        fun login(correo: String, password: String)
    }
}
