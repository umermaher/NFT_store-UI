package com.example.nftstore.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nftstore.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signupPassword.animate().alpha(1f).duration=800L

        signupSignupBtn.setOnClickListener {
            val intent= Intent(this, ProfilePictureActivity::class.java)

            startActivity(intent)
        }
    }
}