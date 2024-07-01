package ec.edu.espoch.aplicativo.about.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.about.AboutContract
import ec.edu.espoch.aplicativo.about.AboutMain
import ec.edu.espoch.aplicativo.about.presenter.AboutPresenter

class AboutFragment : Fragment(), AboutContract.View {

    private lateinit var adapter: AboutAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: AboutContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewAbout)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize adapter
        adapter = AboutAdapter { desarrollador ->
            // Aquí puedes manejar el clic en un elemento del RecyclerView si es necesario
        }

        // Configure RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        // Initialize presenter and load data
        presenter = AboutPresenter(this)
        presenter.loadDesarrolladores()
    }

    override fun showLoader() {
        // Mostrar un indicador de carga si es necesario
    }

    override fun hideLoader() {
        // Ocultar el indicador de carga si es necesario
    }

    override fun showDesarrolladores(desarrolladores: List<AboutMain>) {
        Log.d("AboutFragment", "Mostrando desarrolladores: $desarrolladores")
        adapter.setDesarrolladores(desarrolladores)
    }
}
