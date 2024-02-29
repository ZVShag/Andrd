package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ulogin: EditText=findViewById(R.id.login)
        var uemail:EditText=findViewById(R.id.email)
        var upass:EditText=findViewById(R.id.password)
        var button:Button=findViewById(R.id.button)
        var lnk:TextView=findViewById(R.id.sign)
        lnk.setOnClickListener {
            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            var login=ulogin.text.toString().trim()
            var email=uemail.text.toString().trim()
            var pass=upass.text.toString().trim()
            if (login=="" || email=="" || pass=="")
                Toast.makeText(this,"Не заполнены поля",Toast.LENGTH_LONG)
            else
            {
                val user=user(login,email,pass)
                val db=Db(this,null)
                db.add(user)

            }
        }
    }
}