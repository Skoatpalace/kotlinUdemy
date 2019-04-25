package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MapCollectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_collection)

        val languages = mutableMapOf(
            "Kotlin" to "Est une île en Sibérie",
            "Java" to "Est une île d'Indonésie"
        )
        languages["C++"] = "Une des origines du Java"
        //est égale a languages.put("C++", "Une des origines du Java")
        println(languages)

        println("Valeur de la clé Kotlin : ${languages["Kotlin"]}")

        //faire une recherche dans une map

        if (!languages.contains("Python")){
            println("Il manque le Python !")
        }

        //parcours des clés

        for (key in languages.keys) println(key)

        //parcours des valeurs

        for (entry in languages.entries)
            println("${languages.keys} => ${languages.values}")

        //multi déclaration

        for ((key, value) in languages)
            println("$key ===> $value")

        val nonCppLanguages = languages
            .filterNot { it.key == "C++" }
            .mapValues { it.value.toUpperCase() }

        println(nonCppLanguages)



    }
}
