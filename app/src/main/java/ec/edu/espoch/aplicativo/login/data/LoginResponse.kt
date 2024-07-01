package ec.edu.espoch.aplicativo.login.data

import ec.edu.espoch.aplicativo.register.Usuario

data class LoginResponse(
    val message: String,
    val usuario: Usuario?
)