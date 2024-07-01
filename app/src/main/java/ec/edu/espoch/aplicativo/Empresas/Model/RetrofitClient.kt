package ec.edu.espoch.aplicativo.Empresas.Model


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
<<<<<<< HEAD
    private const val BASE_URL = "http://192.168.1.15/android_mysql/buscar_producto.php/" // Reemplaza con la dirección IP de tu servidor
=======
    private const val BASE_URL = "http://192.168.2.111/android_mysql/" // Reemplaza con la dirección IP de tu servidor
>>>>>>> 6e5e23237813ae028e78e789af13b926c73f5c0b

    val apiService: EmpresaApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EmpresaApiService::class.java)
    }
}
