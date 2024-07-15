package ec.edu.espoch.aplicativo.register.data

import android.content.Context
import android.content.SharedPreferences
import ec.edu.espoch.aplicativo.register.RegisterContract
import ec.edu.espoch.aplicativo.register.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterInteractor(private val context: Context) : RegisterContract.Presenter {

    private val apiService = ApiClient.retrofit.create(ApiService::class.java)
    private lateinit var view: RegisterContract.View

    override fun agregarUsuario(usuario: Usuario) {
        val call = apiService.agregarUsuario(usuario)

        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    saveUserData(usuario)
                    view.mostrarMensajeExito()
                } else {
                    val errorBody = response.errorBody()?.string() ?: "Error desconocido"
                    view.mostrarMensajeError("Error: ${response.code()} - $errorBody")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                view.mostrarMensajeError("Error al conectar con el servidor: ${t.message}")
            }
        })
    }

    override fun setView(view: RegisterContract.View) {
        this.view = view
    }

    private fun saveUserData(usuario: Usuario) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString("nombre", usuario.nombre)
            putString("apellido", usuario.apellido)
            putString("correo", usuario.correo)
            putString("contrasenia", usuario.password)
            apply()
        }
    }
}
