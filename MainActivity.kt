package com.ftycgames.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var txtAd : EditText
    lateinit var txtSoyad : EditText
    lateinit var txtMail : EditText
    lateinit var txtSifre : EditText
    lateinit var btnKayit :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shared = getSharedPreferences("users", MODE_PRIVATE)
        val editor = shared.edit()

        btnKayit = findViewById(R.id.btnKayit)

        btnKayit.setOnClickListener {
            txtAd = findViewById(R.id.txtIsim)
            txtSoyad = findViewById(R.id.txtSoyisim)
            txtMail = findViewById(R.id.txtMail)
            txtSifre = findViewById(R.id.txtSifre)

            val email = txtMail.text.toString()
            val ad = txtAd.text.toString()
            val soyad = txtSoyad.text.toString()
            val sifre = txtSifre.text.toString()

            if ( email.equals("")) {
                Toast.makeText(this@MainActivity,"Email boş!",Toast.LENGTH_SHORT).show()
            }
            else if ( ad.equals("")) {
                Toast.makeText(this@MainActivity,"Ad boş!",Toast.LENGTH_SHORT).show()
            }
            else if ( soyad.equals("")) {
                Toast.makeText(this@MainActivity,"Soyad boş!",Toast.LENGTH_SHORT).show()
            }
            else if ( sifre.equals("")) {
                Toast.makeText(this@MainActivity,"Sifre boş!",Toast.LENGTH_SHORT).show()
            }
            else{
                editor.putString("mail", txtMail.toString())
                editor.putString("ad", txtAd.toString())
                editor.putString("soyad", txtSoyad.toString())
                editor.putString("sifre", txtSifre.toString())
                editor.commit()
                Toast.makeText(this@MainActivity, "Kayıt Başarılı Oldu", Toast.LENGTH_LONG).show()
                val i = Intent(this@MainActivity, Login::class.java )
                startActivity(i)
            }
        }
    }
}