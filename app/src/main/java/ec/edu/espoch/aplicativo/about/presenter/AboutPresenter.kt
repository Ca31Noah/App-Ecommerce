package ec.edu.espoch.aplicativo.about.presenter

import ec.edu.espoch.aplicativo.about.AboutContract
import ec.edu.espoch.aplicativo.about.model.AboutInteractor

class AboutPresenter(private val view: AboutContract.View) : AboutContract.Presenter {
    private val aboutInteractor = AboutInteractor()
    override fun loadDesarrolladores() {
        view.showLoader()
        aboutInteractor.getDesarrolladores { desarrolladores ->
            view.hideLoader()
            view.showDesarrolladores(desarrolladores)
        }
    }
}