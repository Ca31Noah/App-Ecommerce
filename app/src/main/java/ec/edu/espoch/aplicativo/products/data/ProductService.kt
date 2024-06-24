// ProductService.kt
package ec.edu.espoch.aplicativo.products.data

import ec.edu.espoch.aplicativo.products.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {
    @GET("listar.php") // Asegúrate de que este endpoint sea correcto
    fun getProducts(): Call<List<Product>>
}
