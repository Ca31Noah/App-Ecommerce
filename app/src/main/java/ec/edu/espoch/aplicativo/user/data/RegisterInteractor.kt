package ec.edu.espoch.aplicativo.user.data

import ec.edu.espoch.aplicativo.user.Usuario
import ec.edu.espoch.aplicativo.user.presenter.RegisterContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterInteractor : RegisterContract.Presenter {

    private val apiService = ApiClient.retrofit.create(ApiService::class.java)
    private lateinit var view: RegisterContract.View // Propiedad lateinit

    override fun agregarUsuario(usuario: Usuario) {
        val call = apiService.agregarUsuario(usuario)

        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    view.mostrarMensajeExito() // Acceso a 'view' aquí
                } else {
                    view.mostrarMensajeError("Error al agregar usuario")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                view.mostrarMensajeError("Error al conectar con el servidor")
            }
        })
    }

    override fun setView(view: RegisterContract.View) {
        this.view = view // Inicialización de 'view'
    }
}
