package ec.edu.espoch.aplicativo.about

import ec.edu.espoch.aplicativo.register.Usuario

interface AboutContract {

    interface View {
        fun mostrarPerfilUsuario(usuario: Usuario)
        fun mostrarError(mensaje: String)
    }

    interface Presenter {
        fun obtenerPerfilUsuario(idUsuario: Int)
    }

    interface Interactor {
        interface OnFinishedListener {
            fun onFinished(usuario: ec.edu.espoch.aplicativo.register.Usuario)
            fun onError(mensaje: String)
        }

        fun obtenerPerfilUsuario(idUsuario: Int, listener: OnFinishedListener)
    }
}
