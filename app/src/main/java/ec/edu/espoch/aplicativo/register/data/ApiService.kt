package ec.edu.espoch.aplicativo.register.data

import ec.edu.espoch.aplicativo.login.data.LoginRequest
import ec.edu.espoch.aplicativo.login.data.LoginResponse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT


interface ApiService {
    @POST("register.php")
    fun agregarUsuario(@Body usuario: ec.edu.espoch.aplicativo.register.Usuario): Call<Void>

    @POST("login.php")
    fun login(@Body credentials: LoginRequest): Call<LoginResponse>


}
