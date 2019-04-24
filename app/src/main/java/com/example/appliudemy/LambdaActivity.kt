package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

//Unit de kotlin = void de java
fun arrayAction(array: Array<Int>, action: (Int) -> Unit){
    for (a in array){
        action(a)
    }
}

class LambdaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lambda)

        val numbers  = arrayOf(-99, -42, -6, -5, 0, 18, 87, 119)

        numbers.filter({number -> number > 0})
        //encore plus simplifié
        numbers.filter({it > 0})
        //encore +
        numbers.filter { it % 2 == 0 }

        arrayAction(numbers, {number -> println(number)})
        // est egale à
        arrayAction(numbers){
            number -> println(number)
        }
        //ou
        numbers.forEach { println(it) }
        
        numbers.forEachIndexed { index, number -> println("index = $index, number = $number") }

        val button = Button(this)

        button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?) {
                 println("click")
            }
        })

        //est égal à
        button.setOnClickListener({view -> println("click")})

        //est égal à
        button.setOnClickListener { println("click") }
    }
}
