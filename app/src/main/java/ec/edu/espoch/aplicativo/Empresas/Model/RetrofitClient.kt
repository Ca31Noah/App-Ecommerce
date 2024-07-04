package ec.edu.espoch.aplicativo.Empresas.Model


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://192.168.1.18/android_mysql/" // Reemplaza con la dirección IP de tu servidor

    val apiService: EmpresaApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EmpresaApiService::class.java)
    }
}
