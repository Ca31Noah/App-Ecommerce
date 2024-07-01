package ec.edu.espoch.aplicativo.login.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login.php")
    fun login(@Body credentials: LoginRequest): Call<LoginResponse>
}
