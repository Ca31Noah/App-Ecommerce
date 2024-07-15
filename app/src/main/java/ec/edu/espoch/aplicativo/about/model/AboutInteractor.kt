package ec.edu.espoch.aplicativo.about.model

import android.content.Context
import android.content.SharedPreferences
import ec.edu.espoch.aplicativo.login.Usuario

class AboutInteractor(private val context: Context) {

    fun obtenerDatosUsuario(): Usuario? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val nombre = sharedPreferences.getString("nombre", null)
        val apellido = sharedPreferences.getString("apellido", null)
        val correo = sharedPreferences.getString("correo", null)

        return if (nombre != null && apellido != null && correo != null) {
            Usuario(nombre, apellido, correo, "") // No se guarda la contraseña en el perfil
        } else {
            null
        }
    }
}
