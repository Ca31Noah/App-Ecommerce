package ec.edu.espoch.aplicativo.about


import ec.edu.espoch.aplicativo.login.Usuario

interface AboutContract {
    interface View {
        fun mostrarError(mensaje: String)
        fun mostrarDatosUsuario(usuario: Usuario)
    }

    interface Presenter {
        fun obtenerDatosUsuario()
    }

    interface Interactor {
        interface OnFinishedListener {
            fun onFinished(usuario: Usuario)
            fun onFailure(mensaje: String)
        }

        fun obtenerDatosUsuario(callback: OnFinishedListener)
    }
}
