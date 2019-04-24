package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.*

fun filterInts(numbers: Array<Int>, param: (Int) -> Boolean): Array<Int>{
    val filteredNumbers = mutableListOf<Int>()

    for (n in numbers){
        if(param(n)){
            filteredNumbers.add(n)
        }
    }
    return filteredNumbers.toTypedArray()
}

fun positiveInt(n: Int): Boolean = n >= 0
fun evenInt(n: Int): Boolean = n % 2 == 0

class HightOrderFunctionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hight_order_function)

        val numbers  = arrayOf(-99, -42, -6, -5, 0, 18, 87, 119)
        val positiveNumbers = filterInts(numbers, ::positiveInt)
        println("nombres positifs: ${Arrays.toString(positiveNumbers)}")

        val evenNumbers = filterInts(numbers, ::evenInt)
        println("nombres pairs: ${Arrays.toString(evenNumbers)}")

        val positiveEvenNumbers = filterInts(
            filterInts(numbers, ::positiveInt), ::evenInt
        )
        println("nombres pairs et positifs: ${Arrays.toString(positiveEvenNumbers)}")

    }
}
