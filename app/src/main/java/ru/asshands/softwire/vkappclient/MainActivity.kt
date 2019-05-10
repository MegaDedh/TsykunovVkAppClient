package ru.asshands.softwire.vkappclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.asshands.softwire.vkappclient.navigation.Navigator
import ru.asshands.softwire.vkappclient.navigation.Screen
import ru.terrakok.cicerone.android.support.SupportAppNavigator


class MainActivity : AppCompatActivity() {

    private lateinit var navigator: SupportAppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator = Navigator(this, supportFragmentManager, R.id.content)

        //App.INSTANCE.router.newRootScreen(Screen.ProfileViewScreen())
        App.INSTANCE.router.newRootScreen(Screen.SplashScreen())
    }

    override fun onResume() {
        super.onResume()
        App.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.INSTANCE.navigatorHolder.removeNavigator()
    }
}
