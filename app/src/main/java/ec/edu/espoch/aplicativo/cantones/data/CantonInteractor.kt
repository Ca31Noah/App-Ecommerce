package ec.edu.espoch.aplicativo.cantones.data

import android.os.Handler
import android.os.Looper
import ec.edu.espoch.aplicativo.cantones.CantonesMain

class CantonInteractor {

    fun getCantones(callback: (List<CantonesMain>) -> Unit) {
        val cantones = listOf(
            CantonesMain(
                1,
                "Coca",
                "https://macco.ec/wp-content/uploads/2020/03/logotipo-GADMFO.png"
            ),
            CantonesMain(
                2,
                "Sacha",
                "https://pbs.twimg.com/profile_images/1658133088872935424/F74Dk3Ng_400x400.jpg"
            ),
            CantonesMain(
                3,
                "Loreto",
                "https://maprs.gob.ec/wp-content/uploads/2020/08/LOGO-ADMINISTRACION-1.png"
            ),
            CantonesMain(
                4,
                "Aguarico",
                "https://aguarico.gob.ec/wp-content/uploads/2023/05/logotipo-final-Aguarico--e1685568256437.png"
            )
        )

        Handler(Looper.getMainLooper()).postDelayed({
            callback(cantones)
        }, 500)
    }
}
