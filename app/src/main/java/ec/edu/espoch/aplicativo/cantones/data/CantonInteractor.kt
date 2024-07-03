package ec.edu.espoch.aplicativo.cantones.data

import android.os.Handler
import android.os.Looper
import ec.edu.espoch.aplicativo.cantones.CantonesContract
import ec.edu.espoch.aplicativo.cantones.CantonesMain

class CantonInteractor : CantonesContract.OnResponseCallBack {

    private val empresasPorCanton: Map<Int, List<String>> = mapOf(
        1 to listOf("1", "2"), // Cantón Coca tiene empresas con ID 1 y 2
        2 to listOf("3", "4"), // Cantón Sacha tiene empresas con ID 3 y 4
        3 to listOf("5", "6"), // Cantón Loreto tiene empresas con ID 5 y 6
        4 to listOf("7", "8")  // Cantón Aguarico tiene empresas con ID 7 y 8
    )

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

    override fun onResponse(cantones: List<CantonesMain>) {
        // Aquí puedes manejar la respuesta si es necesario
    }

    fun getEmpresasPorCanton(cantonId: Int): List<String> {
        return empresasPorCanton[cantonId] ?: emptyList()
    }
}
