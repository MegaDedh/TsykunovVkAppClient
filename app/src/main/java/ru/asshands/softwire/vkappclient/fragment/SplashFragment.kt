package ru.asshands.softwire.vkappclient.fragment

import ru.asshands.softwire.vkappclient.App
import ru.asshands.softwire.vkappclient.R
import ru.asshands.softwire.vkappclient.navigation.Screen
import kotlinx.android.synthetic.main.frament_splash.*


class SplashFragment : BaseFragment(R.layout.frament_splash) {

    override fun onResume() {
        super.onResume()
        asd.postDelayed({
            App.INSTANCE.router.replaceScreen(Screen.LoginScreen())
        }, 3000)
    }

}