package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SetCollectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_collection)

        val uniqueNames = mutableSetOf("bob", "bobette")
        println(uniqueNames)

        uniqueNames.add("Mike")
        uniqueNames.add("John")
        uniqueNames.add("Bob") // pas de doublon possible avec les set
        println(uniqueNames)

        val roUniqueNames = setOf(uniqueNames)
        for (name in roUniqueNames){
            println(name)
        }
        println("Element à l'indice 2: ${roUniqueNames.elementAt(2)}")

        val list: List<String> = uniqueNames
            .filter { it.startsWith("J") }
            .sorted()
        println("Set filtré par la lettre J : $list")
    }
}
