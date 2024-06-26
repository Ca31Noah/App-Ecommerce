package ec.edu.espoch.aplicativo.Empresas.Model


import retrofit2.Call
import retrofit2.http.GET

interface EmpresaApiService {
    @GET("buscar_producto.php")
    fun obtenerEmpresas(): Call<List<Empresa>>
}