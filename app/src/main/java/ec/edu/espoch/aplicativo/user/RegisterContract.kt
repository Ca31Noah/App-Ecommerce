package ec.edu.espoch.aplicativo.user

interface RegisterContract {

    interface View {
        fun mostrarMensajeExito()
        fun mostrarMensajeError(error: String)
    }

    interface Presenter {
        fun agregarUsuario(usuario: Usuario)
        fun setView(view: View) // Añadir esta línea para definir setView en la interfaz Presenter
    }
}
