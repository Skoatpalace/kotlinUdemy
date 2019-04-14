package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

//class data spécial kotlin implémente automaatiquement toString equals hashcode

data class Utilisateur(val name: String, val age: Int){
    override fun toString(): String {
        return "name: $name - age: $age"
    }
}

class DataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val bob = Utilisateur("Bob", 10)
        println("Infos sur : $bob")

        val bobette = Utilisateur("Bobette", 10)
        println("Infos sur : $bobette")

        //utilisation de copy

        val john = bob.copy("John")
        println("Infos sur : $john")

        if(bob == john){
            println("Ils sont pareils")
        }else{
            println("Ils sont différents")
        }
    }
}
