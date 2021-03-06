package com.fuimonos.app.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.fuimonos.app.R
import com.fuimonos.app.appnavigator.AppNavigatorActivity
import com.fuimonos.app.commons.BaseViewModelActivity
import com.fuimonos.app.login.LoginActivity
import kotlinx.android.synthetic.main.act_splash.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseViewModelActivity<SplashViewModel>() {

    override val mViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_splash)
        setup()
    }

    private fun setup() {
        mViewModel.start()
    }

    override fun setupSubscription() {
        super.setupSubscription()
        mViewModel.onShowLoginScreen.observe(this, Observer {
            showLogin()
        })
        mViewModel.onShowMainScreen.observe(this, Observer {
            showMainScreen()
        })
    }

    private fun showLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_CLEAR_TASK or
                Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }

    private fun showMainScreen() {
        val intent = Intent(this, AppNavigatorActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_CLEAR_TASK or
                Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }

}
