package ec.edu.espoch.aplicativo.home.data

import ec.edu.espoch.aplicativo.products.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeInteractor {

    private val BASE_URL = "http://10.0.2.2/android_mysql/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    fun buscarProductos(nombre: String, callback: (List<Product>?, String?) -> Unit) {
        val call = apiService.buscarProductosPorNombre(nombre)
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val productos = response.body()
                    callback(productos, null)
                } else {
                    callback(null, "Error en la respuesta: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                callback(null, "Error de red: ${t.message}")
            }
        })
    }

    fun listarTodosLosProductos(callback: (List<Product>?, String?) -> Unit) {
        val call = apiService.listarTodosLosProductos()
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val productos = response.body()
                    callback(productos, null)
                } else {
                    callback(null, "Error en la respuesta: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                callback(null, "Error de red: ${t.message}")
            }
        })
    }

    fun listarProductosMasVendidos(callback: (List<Product>?, String?) -> Unit) {
        val call = apiService.listarProductosMasVendidos()
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val productos = response.body()
                    callback(productos, null)
                } else {
                    callback(null, "Error en la respuesta: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                callback(null, "Error de red: ${t.message}")
            }
        })
    }
}

