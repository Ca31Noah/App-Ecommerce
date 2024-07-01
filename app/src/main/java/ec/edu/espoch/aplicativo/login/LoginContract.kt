package ec.edu.espoch.aplicativo.login

interface LoginContract {

    interface View {
        fun showLoader()
        fun hideLoader()
        fun mostrarMensajeExito(mensaje: String)
        fun mostrarMensajeError(mensaje: String)
        fun navigateToMain()
    }

    interface Presenter {
        fun login(correo: String, password: String)
    }

    interface OnResponseCallBack {
        fun onResponseSuccess()
        fun onResponseError(mensaje: String)
    }
}
