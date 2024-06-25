package ec.edu.espoch.aplicativo.user.view

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.user.RegisterContract
import ec.edu.espoch.aplicativo.user.Usuario
import ec.edu.espoch.aplicativo.user.data.RegisterInteractor
import ec.edu.espoch.aplicativo.user.presenter.RegisterPresenter

class RegistroActivity : AppCompatActivity(), RegisterContract.View {

    private lateinit var presenter: RegisterPresenter
    private lateinit var editTextNombre: EditText
    private lateinit var editTextApellido: EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        // Inicializar vistas usando findViewById
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextApellido = findViewById(R.id.editTextApellido)
        editTextCorreo = findViewById(R.id.editTextCorreo)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonRegistrar = findViewById(R.id.buttonRegistrar)

        // Crear instancia del interactor y presentador
        val interactor = RegisterInteractor()
        presenter = RegisterPresenter(interactor)
        presenter.setView(this) // Inicialización de la vista

        // Lógica para manejar el evento de agregar usuario
        buttonRegistrar.setOnClickListener {
            val nombre = editTextNombre.text.toString()
            val apellido = editTextApellido.text.toString()
            val correo = editTextCorreo.text.toString()
            val password = editTextPassword.text.toString()

            val usuario = Usuario(nombre, apellido, correo, password)
            Log.d("RegistroActivity", "Enviando usuario: $usuario")
            presenter.agregarUsuario(usuario)
        }
    }

    override fun mostrarMensajeExito() {
        Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
        Log.d("RegistroActivity", "Usuario registrado correctamente")
    }

    override fun mostrarMensajeError(error: String) {
        Toast.makeText(this, "Error: $error", Toast.LENGTH_SHORT).show()
        Log.e("RegistroActivity", "Error: $error")
    }
}
