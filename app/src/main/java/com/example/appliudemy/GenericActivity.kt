package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

/*TODO fonction générique*/

fun <T> printArray(array: Array<T>){

    var separator = ""
    val sb = StringBuilder()
    for (i in array.indices.reversed()){
        sb.append(separator)
        sb.append(array[i])

        separator = ", "
    }
    println(sb.toString())
}

/*TODO classe générique*/

class Box<T>(var value: T){

    fun set(newValue: T){
        value = newValue
    }

    fun get(): T{
        return value
    }
}

class GenericActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generic)


        //exemple utilisation fonction générique

        val integers = arrayOf(1, 2, 3, 4)
        val strings = arrayOf("hello", "world", "en", "kotlin")

        printArray(integers)
        printArray(strings)

        //exemple classe générique

        val boxInt = Box<Int>(2)
        val v: Int = boxInt.get()
        println("box value est $v")

        val boxString = Box<String>("Kotlin")
        println("Box content: ${boxString.get()}")
        boxString.set("rocks")
        println("Box content: ${boxString.get()}")
    }
}
