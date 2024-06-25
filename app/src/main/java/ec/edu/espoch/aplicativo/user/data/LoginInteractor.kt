package ec.edu.espoch.aplicativo.user.data

import android.util.Log
import ec.edu.espoch.aplicativo.user.presenter.LoginContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginInteractor {

    private val apiService = ApiClient.retrofit.create(ApiService::class.java)
    private lateinit var view: LoginContract.View

    fun login(correo: String, password: String) {
        val request = LoginRequest(correo, password)
        val call = apiService.login(request)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        if (loginResponse.usuario != null) {
                            view.mostrarMensajeExito("¡Inicio de sesión exitoso!")
                            // Aquí podrías guardar el usuario en sesión o realizar otras acciones
                        } else {
                            view.mostrarMensajeError("Credenciales incorrectas")
                        }
                    } else {
                        view.mostrarMensajeError("Respuesta nula del servidor")
                    }
                } else {
                    Log.e("LoginInteractor", "Error: ${response.code()} - ${response.message()}")
                    view.mostrarMensajeError("Error: ${response.code()} - ${response.message()}")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("LoginInteractor", "Error al conectar con el servidor: ${t.message}")
                view.mostrarMensajeError("Error al conectar con el servidor: ${t.message}")
            }
        })
    }

    fun setView(view: LoginContract.View) {
        this.view = view
    }
}
