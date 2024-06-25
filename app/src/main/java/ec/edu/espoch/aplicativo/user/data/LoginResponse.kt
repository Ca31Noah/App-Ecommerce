package ec.edu.espoch.aplicativo.user.data

import ec.edu.espoch.aplicativo.user.Usuario

data class LoginResponse(
    val message: String,
    val usuario: Usuario?
)