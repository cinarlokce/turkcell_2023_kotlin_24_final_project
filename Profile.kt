package com.ftycgames.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

lateinit var txtProfileView : TextView
lateinit var btnExit : Button

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        txtProfileView = findViewById(R.id.txtProfileView)
        btnExit = findViewById(R.id.btnExit)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        val shared = getSharedPreferences("users", MODE_PRIVATE)
        val email = shared.getString("email", "")
        val ad = shared.getString("ad", "")
        val soyad = shared.getString("soyad", "")

        txtProfileView.setText("Hoş Geldiniz Sn. $ad $soyad $email")

        btnExit.setOnClickListener {
            val edit = shared.edit()
            edit.remove("email")
            edit.commit()
            finish()
        }
    }
}