package ec.edu.espoch.aplicativo.about.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.about.AboutContract
import ec.edu.espoch.aplicativo.about.presenter.AboutPresenter
import ec.edu.espoch.aplicativo.about.model.AboutInteractor
import ec.edu.espoch.aplicativo.login.LoginActivity
import ec.edu.espoch.aplicativo.login.Usuario

class AboutFragment : Fragment(), AboutContract.View {

    private lateinit var presenter: AboutContract.Presenter
    private lateinit var textViewNombre: TextView
    private lateinit var textViewApellido: TextView
    private lateinit var textViewCorreo: TextView
    private lateinit var buttonCerrarSesion: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        textViewNombre = view.findViewById(R.id.text_view_nombre)
        textViewApellido = view.findViewById(R.id.text_view_apellido)
        textViewCorreo = view.findViewById(R.id.text_view_correo)
        buttonCerrarSesion = view.findViewById(R.id.button_cerrar_sesion)

        // Crear instancia del interactor y presentador
        val interactor = AboutInteractor(requireContext()) // Usar requireContext() en fragmentos
        presenter = AboutPresenter(interactor, this)

        presenter.obtenerDatosUsuario()

        // Manejar clic del botón de cerrar sesión
        buttonCerrarSesion.setOnClickListener {
            cerrarSesion()
        }

        return view
    }

    override fun mostrarDatosUsuario(usuario: Usuario) {
        textViewNombre.text = usuario.nombre
        textViewApellido.text = usuario.apellido
        textViewCorreo.text = usuario.correo
    }

    override fun mostrarError(mensaje: String) {
        Toast.makeText(requireContext(), mensaje, Toast.LENGTH_SHORT).show()
    }

    private fun cerrarSesion() {
        // Limpiar SharedPreferences
        val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences("user_data", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            clear()
            apply()
        }

        // Redirigir al usuario a la pantalla de inicio de sesión
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
}
