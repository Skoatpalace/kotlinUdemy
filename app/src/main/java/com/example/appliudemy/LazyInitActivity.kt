package com.example.appliudemy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class LazyInitActivity : AppCompatActivity() {

    val helloWorldLazy: TextView by lazy {
        println("Lazy init !")
        findViewById<TextView>(R.id.lazy_tv)
    }

    lateinit var helloWorldLate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lazy_init)

        println(helloWorldLazy.text) // premiere initialisation
        helloWorldLate = findViewById<TextView>(R.id.lazy_tv)
    }



    override fun onResume() {
        super.onResume()
        println(helloWorldLazy.text)
        println("Late init: ${helloWorldLate.text}")
    }
}
