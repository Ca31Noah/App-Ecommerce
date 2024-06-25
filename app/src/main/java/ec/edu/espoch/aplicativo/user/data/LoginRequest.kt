package ec.edu.espoch.aplicativo.user.data

data class LoginRequest(
    val correo: String,
    val password: String
)