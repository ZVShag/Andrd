package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Db (val context:Context,val factory:SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context,"first",factory,1) {
    override fun onCreate(db: SQLiteDatabase?) {
       val query="Create Table users (id INT PRIMARY KEY,login TEXT,email TEXT,password TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun add(user:user)
    {
        val values=ContentValues()
        values.put("login",user.login)
        values.put("email",user.email)
        values.put("pass",user.pass)
        val db=this.writableDatabase
        db.insert("users",null,values)
        db.close()
    }
    fun getuser(login:String,password:String):Boolean
    {
        val db=this.readableDatabase
        val result=db.rawQuery("SELECT * FROM user WHERE login='$login' and password='$password'",null)
        return result.moveToFirst()
    }
}