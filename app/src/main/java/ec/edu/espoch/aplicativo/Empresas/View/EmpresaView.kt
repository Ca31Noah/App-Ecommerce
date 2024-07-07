package ec.edu.espoch.aplicativo.Empresas.View

import ec.edu.espoch.aplicativo.Empresas.Empresa


interface EmpresaView {
    fun mostrarEmpresas(empresas: List<Empresa>)
    fun mostrarError(mensaje: String)

}