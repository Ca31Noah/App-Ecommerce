package ec.edu.espoch.aplicativo.register

interface RegisterContract {

    interface View {
        fun mostrarMensajeExito()
        fun mostrarMensajeError(error: String)

        fun getUserName(): String
        fun getUserEmail(): String
        fun getUserPassword(): String
    }

    interface Presenter {
        fun agregarUsuario(usuario: Usuario)
        fun setView(view: View)
    }

    interface OnResponseCallBack {
        fun onResponse(success: Boolean, errorMessage: String?)
    }
}
