package ec.edu.espoch.aplicativo.about.model

import android.os.Handler
import android.os.Looper
import android.util.Log
import ec.edu.espoch.aplicativo.about.AboutContract
import ec.edu.espoch.aplicativo.about.AboutMain

class AboutInteractor : AboutContract.OnResponseCallBack {
    fun getDesarrolladores(callback: (List<AboutMain>) -> Unit) {
        val desarrolladores = listOf(
            AboutMain(
                1,
                "Carlos Noa",
                "https://scontent.fuio2-1.fna.fbcdn.net/v/t39.30808-1/444487480_1135558724423615_2026363294580267043_n.jpg?stp=dst-jpg_s200x200&_nc_cat=101&ccb=1-7&_nc_sid=0ecb9b&_nc_eui2=AeGPOmwBM9vuRKpUs59uMCrBIRJW5dMe9cQhElbl0x71xLRO6NFbSxF4gJiGaE5tjM64iQ_JsOi72ObqywAanizX&_nc_ohc=cq1cL2NwrlsQ7kNvgHTDV3J&_nc_ht=scontent.fuio2-1.fna&oh=00_AYDyG3dQxd052TqS3AqE8HXil_4PuC6NwEP0BMZcSZ5wlQ&oe=6687E709"
            ),
            AboutMain(
                2,
                "Sofia Arcos",
                "https://scontent.fuio2-1.fna.fbcdn.net/v/t39.30808-6/246945568_3032107593731210_8602867158492572578_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeEV8n0G7I5zzvzE3_XzB5fqSreh41tCI-5Kt6HjW0Ij7iCxyYOdD23WWrM6X-J29Pu3fVF2W0pkzoMf5GlG4Dsd&_nc_ohc=fdSd_4qjUR8Q7kNvgHetMhL&_nc_ht=scontent.fuio2-1.fna&oh=00_AYArzyv_ivazJsDX3wF2v42w4PtV5oogzuuN-lBJaB9dFg&oe=6687D2C2"
            ),
            AboutMain(
                3,
                "Byron Granda",
                "https://scontent.fuio2-1.fna.fbcdn.net/v/t39.30808-6/438078093_2746678648826592_1653960054105530758_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeHqOljMyE1qhoT5oJ2sv06rytC6t85nsCnK0Lq3zmewKelH8qVNWQpW8XiIpQjju4ic5I_fDKegyVsh7UX8gVod&_nc_ohc=vIHo6Xvkb-MQ7kNvgFpLZjs&_nc_ht=scontent.fuio2-1.fna&oh=00_AYC_yeUAHlCjw3H7al1sPOdtg8p-mbXqD146QQRMs8Pn4w&oe=6687DA8A"
            ),
            AboutMain(
                4,
                "Josselyn Llori",
                "https://scontent.fuio2-1.fna.fbcdn.net/v/t1.6435-9/116341051_2614592182124988_8081277330686831623_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=53a332&_nc_eui2=AeFvn3-NQBu8wS1X7lYkMEebt-h9WjnCche36H1aOcJyF8b8V8NjnI8tAWyYCu2oMXNPdfJt86wb4bP_02bkrz97&_nc_ohc=u53yuehrYx4Q7kNvgFqnS0O&_nc_ht=scontent.fuio2-1.fna&oh=00_AYDqhJCAgkaMD8mgD-bggh8mw8LzKD7qqVfGwpR4l4lT8Q&oe=66A95FC1"
            )
        )
        Handler(Looper.getMainLooper()).postDelayed({
            callback(desarrolladores)
            Log.d("AboutInteractor", "Desarrolladores cargados: $desarrolladores")
        }, 500)
    }

    override fun onResponse(desarrolladores: List<AboutMain>) {
        // Aquí puedes manejar la respuesta si es necesario
    }
}
