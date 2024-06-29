package ec.edu.espoch.aplicativo.user

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.user.data.LoginInteractor
import ec.edu.espoch.aplicativo.user.presenter.LoginPresenter
import ec.edu.espoch.aplicativo.user.view.LoginView

class LoginActivity : AppCompatActivity() {

    private lateinit var presenter: LoginPresenter
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var loginView: LoginView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializar vistas usando findViewById
        editTextCorreo = findViewById(R.id.editTextCorreo)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

        loginView = LoginView(this)
        presenter = LoginPresenter(LoginInteractor()).apply {
            setView(loginView)
        }

        // Lógica para manejar el evento de inicio de sesión
        buttonLogin.setOnClickListener {
            val correo = editTextCorreo.text.toString()
            val password = editTextPassword.text.toString()

            presenter.login(correo, password)
        }
    }
}
