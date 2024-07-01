package ec.edu.espoch.aplicativo.Empresas.View

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ec.edu.espoch.aplicativo.Empresas.Empresa
import ec.edu.espoch.aplicativo.Empresas.Presenter.EmpresaPresenter
import ec.edu.espoch.aplicativo.Empresas.Presenter.EmpresaPresenterImpl
import ec.edu.espoch.aplicativo.R

class EmpresaActivity : AppCompatActivity(), EmpresaView {

    private lateinit var empresaPresenter: EmpresaPresenter
    private lateinit var recyclerViewEmpresas: RecyclerView
    private lateinit var empresaAdapter: EmpresaAdapter
    private var cantonId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empresas)

        cantonId = intent.getIntExtra("cantonId", 0)

        // Configuración de la RecyclerView
        recyclerViewEmpresas = findViewById(R.id.recyclerViewEmpresas)
        recyclerViewEmpresas.layoutManager = LinearLayoutManager(this)

        // Inicializar el Presenter
        empresaPresenter = EmpresaPresenterImpl(this)
        empresaPresenter.cargarEmpresasPorCanton(cantonId)
    }

    override fun mostrarEmpresas(empresas: List<Empresa>) {
        // Asignar el adapter a la RecyclerView (pasando el contexto)
        empresaAdapter = EmpresaAdapter(empresas, this)
        recyclerViewEmpresas.adapter = empresaAdapter
    }

    override fun mostrarError(mensaje: String) {
        // Mostrar un Toast con el mensaje de error
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}
