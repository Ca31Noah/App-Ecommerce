package ec.edu.espoch.aplicativo.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.login.data.LoginInteractor
import ec.edu.espoch.aplicativo.login.presenter.LoginPresenter
import ec.edu.espoch.aplicativo.login.view.LoginView
import ec.edu.espoch.aplicativo.register.RegistroActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var presenter: LoginPresenter
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var textViewNoCuenta: TextView
    private lateinit var loginView: LoginView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializar vistas usando findViewById
        editTextCorreo = findViewById(R.id.editTextCorreo)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewNoCuenta = findViewById(R.id.textViewNoCuenta)

        loginView = LoginView(this)
        presenter = LoginPresenter(LoginInteractor()).apply {
            setView(loginView)
        }

        // Lógica para manejar el evento de inicio de sesión
        buttonLogin.setOnClickListener {
            val correo = editTextCorreo.text.toString()
            val password = editTextPassword.text.toString()

            if (validarCredenciales(correo, password)) {
                presenter.login(correo, password)
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }

        // Navegación a la actividad de registro al hacer clic en "¿No tienes cuenta?"
        textViewNoCuenta.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validarCredenciales(correo: String, password: String): Boolean {
        val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val storedCorreo = sharedPreferences.getString("correo", null)
        val storedPassword = sharedPreferences.getString("contrasenia", null)
        return correo == storedCorreo && password == storedPassword
    }
}
