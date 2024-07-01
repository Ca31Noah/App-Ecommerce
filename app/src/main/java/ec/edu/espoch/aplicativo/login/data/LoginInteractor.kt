package ec.edu.espoch.aplicativo.login.data

import ec.edu.espoch.aplicativo.login.LoginContract
import ec.edu.espoch.aplicativo.register.data.ApiClient
import ec.edu.espoch.aplicativo.register.data.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginInteractor {

    private val apiService = ApiClient.retrofit.create(ApiService::class.java)
    private lateinit var callback: LoginContract.OnResponseCallBack

    fun login(correo: String, password: String) {
        val request = LoginRequest(correo, password)
        val call = apiService.login(request)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse?.usuario != null) {
                        callback.onResponseSuccess()
                    } else {
                        callback.onResponseError("Credenciales incorrectas")
                    }
                } else {
                    val errorMsg = "Error: ${response.code()} - ${response.message()}"
                    callback.onResponseError(errorMsg)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                val errorMsg = "Error al conectar con el servidor: ${t.message}"
                callback.onResponseError(errorMsg)
            }
        })
    }

    fun setCallback(callback: LoginContract.OnResponseCallBack) {
        this.callback = callback
    }
}
