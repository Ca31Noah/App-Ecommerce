package ec.edu.espoch.aplicativo.about.model
import ec.edu.espoch.aplicativo.register.Usuario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("getUserProfile.php") // Reemplaza con tu endpoint correcto
    fun obtenerPerfilUsuario(@Query("id_usuario") idUsuario: Int): Call<Usuario>
}
