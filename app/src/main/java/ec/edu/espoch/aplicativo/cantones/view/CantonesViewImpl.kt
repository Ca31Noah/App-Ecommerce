package ec.edu.espoch.aplicativo.cantones.view

import ec.edu.espoch.aplicativo.cantones.CantonesMain
import ec.edu.espoch.aplicativo.cantones.CantonesView

class CantonesViewImpl(private val adapter: CantonesAdapter) : CantonesView {

    override fun mostrarCantones(cantones: List<CantonesMain>) {
        adapter.setCantones(cantones)
    }
}
