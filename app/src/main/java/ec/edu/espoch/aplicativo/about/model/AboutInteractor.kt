package ec.edu.espoch.aplicativo.about.model

import ec.edu.espoch.aplicativo.about.AboutContract
import ec.edu.espoch.aplicativo.register.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AboutInteractor : AboutContract.Interactor {

    private val apiService: ApiService = ApiClient.retrofit.create(ApiService::class.java)

    override fun obtenerPerfilUsuario(idUsuario: Int, listener: AboutContract.Interactor.OnFinishedListener) {
        val call = apiService.obtenerPerfilUsuario(idUsuario)

        call.enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if (response.isSuccessful) {
                    val usuario = response.body()
                    usuario?.let { listener.onFinished(it) }
                } else {
                    listener.onError("Error al obtener datos del usuario: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                listener.onError("Error de conexión: ${t.message}")
            }
        })
    }
}
