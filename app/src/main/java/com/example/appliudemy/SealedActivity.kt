package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SealedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sealed)

        var age  = execute(10, Operation.Add(1))
        println("Addition : age = $age")

        age = execute(age, Operation.Substract(5))
        println("Soustraction : age = $age")

        age = execute(age, Operation.Increment)
        println("Incrémentation : age = $age")
    }
}
