package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

/*TODO exemple constructeur + lateinit*/

class User(val name: String,
           val age: Int,
           val height: Float){
    lateinit var nickname: String
    val canPlayBasketball = age > 5 && height > 1.50f

    init {
        val basketString = when(canPlayBasketball){
            true -> "est dans l'équipe de basket"
            false -> "ne peut pas jouer au basket"
        }
        println("info user : $name, $age, $basketString")
    }
    /*TODO constructeur secondaire dans constructeur primaire*/
    constructor(name: String) : this(
        name,
        5,
        1.20f
    )
}

class ConstructorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constructor)

        val bob = User("Bob", 10, 1.60f)
        bob.nickname = "boby"
        println("surnom de ${bob.name}: ${bob.nickname}")

        /*TODO recuperation de l'intent*/

        val action = intent.action
        val isUserViewer = intent.hasCategory("UserViewer")

        val extras: Bundle = intent.extras
        val name = extras.getString("name")
        val age = extras.getInt("age")
        Log.i("ConstructorActivity", "action: $action")

    }
}
