package ec.edu.espoch.aplicativo.Empresas.Presenter


import ec.edu.espoch.aplicativo.Empresas.View.EmpresaView
import ec.edu.espoch.aplicativo.Empresas.Model.Empresa
import ec.edu.espoch.aplicativo.Empresas.Model.RetrofitClient


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmpresaPresenterImpl(private val empresaView: EmpresaView) : EmpresaPresenter {

    override fun cargarEmpresas() {
        RetrofitClient.apiService.obtenerEmpresas().enqueue(object : Callback<List<Empresa>> {
            override fun onResponse(call: Call<List<Empresa>>, response: Response<List<Empresa>>) {
                if (response.isSuccessful) {
                    val empresas = response.body()
                    empresas?.let { empresaView.mostrarEmpresas(it) }
                } else {
                    empresaView.mostrarError("Error al obtener empresas: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Empresa>>, t: Throwable) {
                empresaView.mostrarError("Error de conexión: ${t.message}")
            }
        })
    }
}