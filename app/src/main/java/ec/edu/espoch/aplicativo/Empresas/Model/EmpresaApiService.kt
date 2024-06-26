package ec.edu.espoch.aplicativo.Empresas.Model

import ec.edu.espoch.aplicativo.Empresas.Empresa
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EmpresaApiService {
    @GET("buscar_producto.php")
    fun obtenerEmpresas(): Call<List<Empresa>>

    @GET("buscar_producto_por_canton.php")
    fun obtenerEmpresasPorCanton(@Query("id_canton") idCanton: Int): Call<List<Empresa>>
}
