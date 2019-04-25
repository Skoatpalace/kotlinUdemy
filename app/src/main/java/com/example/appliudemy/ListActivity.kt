   package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val numbers = mutableListOf<Int>(1,2,3)
        numbers.add(42)

        val roNumbers: List<Int> = numbers // roNumbers est immutable (non modifiable)

        val evenNumbers = numbers.filter { it % 2 == 0 }
        println(evenNumbers)

        val names = listOf("Bob", null, "Bobette", null, "Mike")
        println(names)

        val longNames = names.filterNotNull()
            .filter { it.length > 3 }
            .map { it.toUpperCase() }
        println(longNames)

        val containsLetterM = names
            .take(3) //prends les 3 premiers élèments de la liste
            .filterNotNull()
            .any { it.toLowerCase().contains("m") }
        println("Au moins un nom contient la lettre m ?  $containsLetterM")
    }
}
