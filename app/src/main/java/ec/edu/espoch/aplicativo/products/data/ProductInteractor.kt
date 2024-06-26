package ec.edu.espoch.aplicativo.products.data

import android.util.Log
import ec.edu.espoch.aplicativo.products.Product
import ec.edu.espoch.aplicativo.products.ProductsContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductInteractor : ProductsContract.Interactor {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.0.121/android_mysql/") //
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(ProductService::class.java)

    override fun getProducts(callback: (List<Product>) -> Unit) {
        service.getProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body()
                    if (products != null) {
                        callback(products)
                    } else {
                        Log.e("ProductInteractor", "Response body is null")
                    }
                } else {
                    Log.e("ProductInteractor", "Response not successful: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.e("ProductInteractor", "Failed to fetch products", t)
            }
        })
    }
}
