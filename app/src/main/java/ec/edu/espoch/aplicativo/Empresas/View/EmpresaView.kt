package ec.edu.espoch.aplicativo.Empresas.View

import ec.edu.espoch.aplicativo.Empresas.Model.Empresa


interface EmpresaView {
    fun mostrarEmpresas(empresas: List<Empresa>)
    fun mostrarError(mensaje: String)

}
