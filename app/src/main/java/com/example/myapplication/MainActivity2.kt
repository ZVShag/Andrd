package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val lnk:TextView=findViewById(R.id.reg)
        val lg:EditText=findViewById(R.id.login)
        val ps:EditText=findViewById(R.id.password)
        val button:Button=findViewById(R.id.button)
        button.setOnClickListener{
            var login=lg.text.toString().trim()
            var password=ps.text.toString().trim()
            if (login.isEmpty() || password.isEmpty())
                Toast.makeText(this,"Не заполнены поля",Toast.LENGTH_LONG)
            else
            {
                val db=Db(this,null)
                if (db.getuser(login,password))
                {
                    Toast.makeText(this,"Welcome",Toast.LENGTH_LONG)
                    lg.text.clear()
                    ps.text.clear()
                    val intent=Intent(this,MainActivity3::class.java)
                    startActivity(intent)
                }


            }
        }
        lnk.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}