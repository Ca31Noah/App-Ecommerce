package ec.edu.espoch.aplicativo


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        // Configurar AppBarConfiguration con los fragments de nivel superior
        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.homeFragment,
            R.id.cantonFragment,
            R.id.aboutFragment,
            R.id.productFragment
        ).build()

        // Configurar BottomNavigationView con NavController
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        NavigationUI.setupWithNavController(navView, navController)

    }
}
