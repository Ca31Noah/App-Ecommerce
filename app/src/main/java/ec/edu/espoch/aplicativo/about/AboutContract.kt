package ec.edu.espoch.aplicativo.about

interface AboutContract {
    interface View {
        fun showLoader()
        fun hideLoader()
        fun showDesarrolladores(desarrolladores: List<AboutMain>)
    }

    interface Presenter {
        fun loadDesarrolladores()
    }

    interface OnResponseCallBack {
        fun onResponse(desarrolladores: List<AboutMain>)
    }
}
