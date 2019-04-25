package com.example.appliudemy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

class UseFonctionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use_fonction)

        val properties = Properties()
        with(properties) {
            setProperty("name", "Bob")
            setProperty("age", "15")
        }

        val file = File("config.properties")

        //JAVA

        var fileOutputStream: FileOutputStream? = null
        try {
            fileOutputStream = FileOutputStream(file)
            properties.store(fileOutputStream, null)
        } catch (e: IOException) {

        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close()
                } catch (e: IOException) {
                    Log.i(e.message, "error")
                }

            }
        }

        //Kotlin équivalent

        FileOutputStream(file).use { fileOutputStream1 ->
            properties.store(fileOutputStream1, null)
        }

        val loadedPropes = Properties().apply {
            FileInputStream(file).use { load(it) }
        }

    }
}
