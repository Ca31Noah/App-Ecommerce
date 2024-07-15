package ec.edu.espoch.aplicativo.home.data

import ec.edu.espoch.aplicativo.products.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("buscar_productos.php")
    fun buscarProductosPorNombre(@Query("nombre") nombre: String): Call<List<Product>>

    @GET("listar_productos.php")
    fun listarTodosLosProductos(): Call<List<Product>>

    @GET("productos_vendidos.php")
    fun listarProductosMasVendidos(): Call<List<Product>>
}

