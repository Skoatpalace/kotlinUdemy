package com.example.appliudemy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


/* TODO fonction isOldEnought isOlder sont equivalentes à coder en dehors des class*/
fun isOlder(age: Int): Boolean {
    age >= 5
    return true
}

fun isOldEnough(age: Int): Boolean = age >= 5

fun describePeople(name: String, age: Int, height: Float) {
    val canPlayString = when (isOldEnough(age)) {
        true -> "peut jouer au basket"
        false -> "ne peut pas jouer au basket"
    }
    println("$name a $age ans, mesure ${height}m et $canPlayString")
}

fun describePeopleDetail(name: String, age: Int, height: Float, detail: String = "Aucun détail") {
    val canPlayString = when (isOldEnough(age)) {
        true -> "peut jouer au basket"
        false -> "ne peut pas jouer au basket"
    }
    println("$name a $age ans, mesure ${height}m et $canPlayString ($detail)")
}

class Car(val wheelsCount: Int = 4) {

    fun honk(){
        println("Pouet pouet")
    }

    fun honkForWheels(){
        println("Honking for wheels")
        for (i in 0..wheelsCount){
            honk()
        }
    }
}


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* TODO variable et String */

        var age: Int = 10
        var name: String = "Bob"
        var height: Float = 1.30F



        println("String template complexe : ${name.capitalize()} a ${age + 5} ans")
        println("String template simple : $name a $age ans")
        println(
            "Concaténation : "
                    + "\nname : " + name
                    + "\nage : " + age
        )
        println(
            """Raw String :
            |nom : $name
            |age : $age
        """.trimMargin()
        )

        /* TODO exemple condition if else */

        if (age >= 5 && height >= 1.50F) {
            println("Bob est assez grand pour jouer au basket")
        } else {
            println("Bob ne peut pas jouer au basket")
        }

        val type = if (age < 10) "Child" else "adulte"
        println("$name est un $type")

        if (name == "Bob") {
            println("$name est un garçon")
        } else if (name == "Bobette") {
            println("$name est une fille")
        } else {
            println("On ne connais pas le genre de $name")
        }

        /* TODO exemple condition when in !in */

        when (name) {
            "bob" -> println("$name est un garçon")
            "bobette" -> println("$name est une fille")
            else -> println("On ne connais pas le genre de $name")
        }

        when (age) {
            in 1..5 -> println("$name est trop jeune")
            in 6..10 -> println("$name peut jouer au basket")
            !in 1..18 -> println("$name ne peut pas jouer avec les enfants")
            else -> println("condition non gérée")
        }

        /* TODO exemple condition when dans une variable */

        val canPlayBasketball = when (age) {
            in 5..10 -> true
            in 20..30 -> true
            else -> false
        }

        println(canPlayBasketball)

        /*TODO immutable val (final en Java)*/

        val age2 = 50
        println(age2)

        /*TODO nullable */

        var name2: String? = "biloute"

        println(name2?.length)

        /*TODO utilisation de la fonction */

        describePeople(name, age, height)

        age = 15
        name = "Bobette"
        height = 1.50F

        describePeopleDetail(name, age, height)
        describePeopleDetail(name, age, height, detail = "c'est une future championne")

        /*TODO tableau val tableau = Array<type>(tailleTableau) {valeur} */

        val ages = Array<Int>(3) { 42 }
        println(ages.get(0))
        println(Arrays.toString(ages))

        val names = Array<String>(5) { "" }
        names.set(0, "Bob")
        println(names.get(0))

        names[1] = "John"
        println(names.get(1))


        /*TODO factory function tableau val tableau = arrayOf(valeur1, valeur2, ...) */

        val ages1 = arrayOf(1, 2, 4)
        val indexAge = 2
        println("le 3eme element est le ${ages1[indexAge]}")

        ages1[indexAge] = 42
        println("le 3eme element est le ${ages1[indexAge]}")

        /*TODO boucle for*/

        for (i in 1..5) {
            println(i)
        }

        for (i in 1..5 step 2) {
            println(i)
        }

        for (i in 10 downTo 1) {
            println(i)
        }

        for (i in 10 downTo 1 step 2) {
            println(i)
        }

        /*TODO boucle foreach for(item in collection){}*/

        val noms: Array<String> = arrayOf("Bob", "Jane", "mike", "Bobinette")

        //avec for simple
        for (i in 0 until noms.size) {
            println(noms[i])
        }

        //avec foreach
        for (nom in noms) {
            println(nom)
        }

        //foreach + index
        for ((index, nom) in noms.withIndex()) {
            println("$nom est à l'index $index")
        }

        //for et continue qui permet de sauter une boucle si la condition est respecté
        for (nom in noms) {
            if (nom == "mike") {
                println("$nom est absent")
                continue
            }
            println("$nom est présent")
        }

        /*TODO boucle while, do - while, continue et break*/

        var unreadEmailCount = 3
        var notificationEnable: Boolean = true

        //boucle while simple
        while (unreadEmailCount > 0) {
            println("Vérification des emails en cours ...")
            println("vous avez $unreadEmailCount email(s) non lu(s)")
            unreadEmailCount--
        }

        //boucle do while qui permet d'afficher un message meme si 0 email
        do {
            println("Vérification des emails en cours ...")
            println("vous avez $unreadEmailCount email(s) non lu(s)")
            unreadEmailCount--
        } while (unreadEmailCount > 0)

        //utilisation du break
        do {
            println("Vérification des emails en cours ...")
            if (!notificationEnable){
                break
            }
            println("vous avez $unreadEmailCount email(s) non lu(s)")
            unreadEmailCount--
        } while (unreadEmailCount > 0)

        /*TODO class Car ligne 32*/

        val car = Car()
        println("Le véhicule à ${car.wheelsCount} roues")
        car.honk()
        car.honkForWheels()

        /*TODO appel de la class  code java*/

        val marie = Admin()
        //SET
        marie.age = 20
        marie.name = "Marie"

        Log.i("MainActivity", "adresse de bob est ${marie.adress}")

        /*TODO les logs du moins important au plus important*/

        val TAG = "MainActivity"
        Log.v(TAG, "Verbose message")
        Log.d(TAG, "Debug message")
        Log.i(TAG, "Info message")
        Log.w(TAG, "Warning message")
        Log.e(TAG, "Error message")
        Log.println(Log.ASSERT, TAG, "Assert message")

        /*TODO intent*/

        //val button = findViewById<Button>(R.id.button_main) deprecated/obsolete

        button_country.setOnClickListener{

            val intent = Intent(this, CountryActivity::class.java)
            /*intent.action = Intent.ACTION_VIEW
            intent.addCategory("UserViewer")
            intent.putExtra("name", "Bob")
            intent.putExtra("age", 50)*/
            startActivity(intent)
        }





    }
}
