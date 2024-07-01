package ec.edu.espoch.aplicativo.login.view

import android.content.Context
import android.widget.Toast
import ec.edu.espoch.aplicativo.login.LoginContract

class LoginView(private val context: Context) : LoginContract.View {

    override fun showLoader() {
        // Aquí podrías mostrar un loader, por ejemplo, un ProgressDialog
        Toast.makeText(context, "Cargando...", Toast.LENGTH_SHORT).show()
    }

    override fun hideLoader() {
        // Aquí podrías esconder el loader
        Toast.makeText(context, "Carga completa", Toast.LENGTH_SHORT).show()
    }

    override fun mostrarMensajeExito(mensaje: String) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
        // Aquí podrías redirigir a la siguiente pantalla o realizar otras acciones después del login exitoso
    }

    override fun mostrarMensajeError(mensaje: String) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
    }
}
