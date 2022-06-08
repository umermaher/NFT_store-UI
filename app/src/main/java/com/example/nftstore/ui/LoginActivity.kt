package com.example.nftstore.ui

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.View
import com.example.nftstore.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.loginComponentView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginSignupBtn.setOnClickListener {
            loginLoginBtn.animate().alpha(0f).duration=800L

            val intent=Intent(this, SignUpActivity::class.java)

//            startActivity(intent)
            val pair= arrayOf(
                Pair<View,String>(loginLogo,getString(R.string.login_signup_logo_tran)),
                Pair<View,String>(wave11,getString(R.string.wave_tran)),
                Pair<View,String>(wave12,getString(R.string.wave2_tran)),
                Pair(loginComponentView,getString(R.string.login_signup_view_tran)),
                Pair<View,String>(loginTitle,getString(R.string.login_signup_trans)),
                Pair<View,String>(loginEmail,getString(R.string.email_editText_tran)),
                Pair<View,String>(loginPassword,getString(R.string.password_editText_tran)),
                Pair<View,String>(loginSignupBtn,getString(R.string.signup_btn_tran))
            )

            val options: ActivityOptions =ActivityOptions.makeSceneTransitionAnimation(this, *pair)
            startActivity(intent,options.toBundle())
        }
    }

    override fun onResume() {
        loginLoginBtn.animate().alpha(1f).duration=100L
        super.onResume()
    }
}