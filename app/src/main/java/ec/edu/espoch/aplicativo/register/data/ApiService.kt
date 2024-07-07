package ec.edu.espoch.aplicativo.register.data

import ec.edu.espoch.aplicativo.login.data.LoginRequest
import ec.edu.espoch.aplicativo.login.data.LoginResponse
import ec.edu.espoch.aplicativo.register.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("register.php")
    fun agregarUsuario(@Body usuario: Usuario): Call<Void>

    @POST("login.php")
    fun login(@Body credentials: LoginRequest): Call<LoginResponse>

}
