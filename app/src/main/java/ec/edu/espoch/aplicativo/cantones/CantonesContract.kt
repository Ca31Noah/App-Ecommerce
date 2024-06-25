package ec.edu.espoch.aplicativo.cantones

interface CantonesContract {
    interface View {
        fun showLoader()
        fun hideLoader()
        fun showCantones(cantones: List<CantonesMain>)
    }

    interface Presenter {
        fun loadCantones()
    }

    interface OnResponseCallBack {
        fun onResponse(cantones: List<CantonesMain>)
    }
}
