package ec.edu.espoch.aplicativo.user.data

import ec.edu.espoch.aplicativo.user.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("ingresar.php")
    fun agregarUsuario(@Body usuario: Usuario): Call<Void>

    @POST("login.php")
    fun login(@Body credentials: LoginRequest): Call<LoginResponse>
}
