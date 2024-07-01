package ec.edu.espoch.aplicativo.register.view

import android.content.Context
import android.widget.Toast
import ec.edu.espoch.aplicativo.register.RegisterContract

class RegisterView(private val context: Context) : RegisterContract.View {
    override fun mostrarMensajeExito() {
        Toast.makeText(context, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
    }

    override fun mostrarMensajeError(error: String) {
        Toast.makeText(context, "Error: $error", Toast.LENGTH_SHORT).show()
    }
}
