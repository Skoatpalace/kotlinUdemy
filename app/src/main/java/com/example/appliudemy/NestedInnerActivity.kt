package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

/*TODO nested class sert à implementer une classe dans une autre en etant indépendant*/

class Bag(itemsCount: Int){

    val items = arrayOfNulls<Item>(itemsCount)

    class Item(val weight: Int){

        fun showWeight(){
            println("Poids de l'item : $weight")
        }
    }
}

/*TODO inner class est egal a la nested class mais il est plus imbriqué il depend de l'outer class*/

class Bus(val wheelsCount: Int){

    inner class Engine {
        fun displayHorsePower(){
            println("Le bus a ${wheelsCount * 34} chevaux")
        }
    }
}

class NestedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested)

        val bag = Bag(2)
        val firstItem = Bag.Item(50)
        firstItem.showWeight()
        bag.items[0] = firstItem
        bag.items[1] = Bag.Item(100)

        val bus = Bus(4)
        val engine = bus.Engine()
        engine.displayHorsePower()

    }
}
