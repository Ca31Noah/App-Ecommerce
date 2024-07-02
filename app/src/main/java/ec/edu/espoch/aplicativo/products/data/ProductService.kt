package ec.edu.espoch.aplicativo.products.data

import ec.edu.espoch.aplicativo.products.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("listar_productos.php")
    fun getProducts(): Call<List<Product>>

    @GET("listar_productos_empresa.php")
    fun getProductsByCompany(@Query("id_empresa") companyId: Int): Call<List<Product>>
}
