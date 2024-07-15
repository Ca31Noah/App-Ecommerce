package ec.edu.espoch.aplicativo.products

data class Product(
    val id_pro_ser: Int,
    val Nombre: String,
    val Descripcion: String,
    val Tipo: String,
    val Precio: Double,
    val imagenUrl: String,
    val ventas: Int,
    val id_empresa: Int

)
