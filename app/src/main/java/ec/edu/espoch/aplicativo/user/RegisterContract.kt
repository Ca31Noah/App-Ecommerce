package ec.edu.espoch.aplicativo.user

interface RegisterContract {

    interface View {
        fun mostrarMensajeExito()
        fun mostrarMensajeError(error: String)
    }

    interface Presenter {
        fun agregarUsuario(usuario: Usuario)
        fun setView(view: View)
    }

    interface OnResponseCallBack {
        fun onResponse(success: Boolean, errorMessage: String?)
    }
}
