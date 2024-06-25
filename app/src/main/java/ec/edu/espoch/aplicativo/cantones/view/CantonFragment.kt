package ec.edu.espoch.aplicativo.cantones.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.cantones.CantonesContract
import ec.edu.espoch.aplicativo.cantones.CantonesMain
import ec.edu.espoch.aplicativo.cantones.presenter.CantonesPresenter

class CantonFragment : Fragment(), CantonesContract.View {

    private lateinit var presenter: CantonesContract.Presenter
    private lateinit var adapter: CantonesAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_canton, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewCantones)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CantonesAdapter { canton ->
            // Handle item click if needed
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        presenter = CantonesPresenter(this)
        presenter.loadCantones()
    }

    override fun showLoader() {
        // Mostrar un indicador de carga
    }

    override fun hideLoader() {
        // Ocultar el indicador de carga
    }

    override fun showCantones(cantones: List<CantonesMain>) {
        adapter.setCantones(cantones)
    }
}
