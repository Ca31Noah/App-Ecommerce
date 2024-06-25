package ec.edu.espoch.aplicativo.user.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.user.LoginContract
import ec.edu.espoch.aplicativo.user.data.LoginInteractor
import ec.edu.espoch.aplicativo.user.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var presenter: LoginPresenter
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializar vistas usando findViewById
        editTextCorreo = findViewById(R.id.editTextCorreo)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

        val interactor = LoginInteractor()
        presenter = LoginPresenter(interactor)
        presenter.setView(this)

        // Lógica para manejar el evento de inicio de sesión
        buttonLogin.setOnClickListener {
            val correo = editTextCorreo.text.toString()
            val password = editTextPassword.text.toString()

            presenter.login(correo, password)
        }
    }

    override fun mostrarMensajeExito(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        // Aquí podrías redirigir a la siguiente pantalla o realizar otras acciones después del login exitoso
    }

    override fun mostrarMensajeError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}
