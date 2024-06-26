// Empresa.kt
package ec.edu.espoch.aplicativo.Empresas

data class Empresa(
    val id: String,
    val Nombre: String,
    val Propietario: String,
    val Email: String,
    val Contacto: String,
    val Direccion: String,
    val imagenUrl: String,
    val id_canton: String
)

