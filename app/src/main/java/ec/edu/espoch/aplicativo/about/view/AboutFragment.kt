package ec.edu.espoch.aplicativo.about.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.about.AboutContract
import ec.edu.espoch.aplicativo.about.model.AboutInteractor
import ec.edu.espoch.aplicativo.about.presenter.AboutPresenter
import ec.edu.espoch.aplicativo.register.Usuario

class AboutFragment : Fragment(), AboutContract.View {

    private lateinit var presenter: AboutPresenter

    // Declarar aquí los TextViews u otros elementos de UI necesarios
    private lateinit var textViewNombre: TextView
    private lateinit var textViewApellido: TextView
    private lateinit var textViewCorreo: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        // Inicializar los elementos de UI
        textViewNombre = view.findViewById(R.id.text_view_nombre)
        textViewApellido = view.findViewById(R.id.text_view_apellido)
        textViewCorreo = view.findViewById(R.id.text_view_correo)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val idUsuario = obtenerIdUsuarioActual()

        val interactor = AboutInteractor() // O puedes inicializarlo de otra manera si es necesario
        presenter = AboutPresenter(interactor, this)

        presenter.obtenerPerfilUsuario(idUsuario)
    }

    override fun mostrarPerfilUsuario(usuario: Usuario) {
        // Mostrar datos del usuario en los TextViews
        textViewNombre.text = usuario.nombre
        textViewApellido.text = usuario.apellido
        textViewCorreo.text = usuario.correo
    }

    override fun mostrarError(mensaje: String) {
        // Manejar el error al obtener el perfil del usuario (puedes mostrar un mensaje de error en un Toast, por ejemplo)
    }

    private fun obtenerIdUsuarioActual(): Int {
        // Implementa la lógica para obtener el ID del usuario actualmente logueado
        return 1
    }
}
