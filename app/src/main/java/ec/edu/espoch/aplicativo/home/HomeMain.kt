package ec.edu.espoch.aplicativo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ec.edu.espoch.aplicativo.home.view.HomeFragment

class HomeMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment())
                .commitNow()
        }
    }
}
