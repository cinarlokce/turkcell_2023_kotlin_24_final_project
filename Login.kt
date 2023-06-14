package com.ftycgames.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

lateinit var girisMail : EditText
lateinit var girisSifre :EditText
lateinit var girisButton : Button
class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        girisMail = findViewById(R.id.girisMail)
        girisSifre = findViewById(R.id.girisSifre)
        girisButton = findViewById(R.id.girisButton)


        val shared = getSharedPreferences("users", MODE_PRIVATE)
        val editor = shared.edit()

        girisButton.setOnClickListener {
            if ( girisMail.equals("")) {
                Toast.makeText(this@Login,"Email boş!", Toast.LENGTH_SHORT).show()
            }
            else if ( girisSifre.equals("")) {
                Toast.makeText(this@Login,"Sifre boş!", Toast.LENGTH_SHORT).show()
            }
            else{
                val email = shared.getString("email","")
                val sifre = shared.getString("sifre","")

                if (email == girisMail.text.toString()){

                    if (sifre == girisSifre.text.toString()) {
                        val i = Intent(this, Profile::class.java )
                        startActivity(i)
                    }
                    else{
                        Toast.makeText(this, "Şifre yanlıştır", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this, "Email yanlıştır", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }


}