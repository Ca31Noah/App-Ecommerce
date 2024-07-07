package ec.edu.espoch.aplicativo.Empresas

data class Empresa(
    val id_empresa: Int,
    val Nombre: String,
    val Propietario: String,
    val Email: String,
    val Contacto: String,
    val Direccion: String,
    val imagenUrl: String,
    val id_canton: Int
)
