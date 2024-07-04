package ec.edu.espoch.aplicativo.register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.login.LoginActivity
import ec.edu.espoch.aplicativo.register.data.RegisterInteractor
import ec.edu.espoch.aplicativo.register.presenter.RegisterPresenter

class RegistroActivity : AppCompatActivity(), RegisterContract.View {

    private lateinit var presenter: RegisterPresenter
    private lateinit var editTextNombre: EditText
    private lateinit var editTextApellido: EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonRegistrar: Button
    private lateinit var textViewYaCuenta: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        // Inicializar vistas usando findViewById
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextApellido = findViewById(R.id.editTextApellido)
        editTextCorreo = findViewById(R.id.editTextCorreo)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonRegistrar = findViewById(R.id.buttonRegistrar)
        textViewYaCuenta = findViewById(R.id.textViewYaCuenta)

        // Configurar clic en "¿Ya tienes cuenta? Inicia sesión aquí"
        textViewYaCuenta.setOnClickListener {
            startActivity(Intent(this@RegistroActivity, LoginActivity::class.java))
            // Opcional: finaliza la actividad actual si no quieres que el usuario vuelva a ella con el botón de retroceso
            // finish()
        }

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

            // Validaciones
            if (!validarNombreApellido(nombre)) {
                mostrarMensajeError("El nombre solo debe contener letras y espacios.")
                return@setOnClickListener
            }

            if (!validarNombreApellido(apellido)) {
                mostrarMensajeError("El apellido solo debe contener letras y espacios.")
                return@setOnClickListener
            }

            if (!validarCorreo(correo)) {
                mostrarMensajeError("El correo electrónico no es válido.")
                return@setOnClickListener
            }

            if (!validarPassword(password)) {
                mostrarMensajeError("La contraseña debe tener al menos 8 caracteres.")
                return@setOnClickListener
            }

            val usuario = Usuario(nombre, apellido, correo, password)
            presenter.agregarUsuario(usuario)
        }
    }

    override fun mostrarMensajeExito() {
        Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
        limpiarCampos()
    }

    override fun mostrarMensajeError(error: String) {
        Toast.makeText(this, "Error: $error", Toast.LENGTH_SHORT).show()
    }

    private fun limpiarCampos() {
        editTextNombre.text.clear()
        editTextApellido.text.clear()
        editTextCorreo.text.clear()
        editTextPassword.text.clear()
    }

    // Funciones de validación
    private fun validarNombreApellido(campo: String): Boolean {
        return campo.matches(Regex("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+\$"))
    }

    private fun validarCorreo(correo: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()
    }

    private fun validarPassword(password: String): Boolean {
        return password.length >= 8
    }
}
