package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.appliudemy.Student.State.ACTIVE

fun validateName(name: String){
    require(name.isNotEmpty()) {"Empty name"}
    for (character in name){
        require(character.isLetter()) {"invalid name, non letter character = $character"}
    }
}

fun sendGift(student: Student){
    require(student.email.isNotEmpty()) {"Empty email"}
    check(student.state == ACTIVE){"Invalide student state : ${student.state}"}
    println("Sending gift to $student")
}

data class Student(val name: String, val email: String){
    enum class State{
        NEW,
        ACTIVE
    }
    var state: State = State.NEW

    init {
        validateName(name)
    }
}

class RequireCheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_require_check)

        validateName("Bob") // rien ne se passe
        val bobette = Student("bobette", "bobette@bob.kt")
        bobette.state = ACTIVE
        sendGift(bobette)

        val bob = Student("bob", "bob@bob.kt")
        sendGift(bob)

        //TODO elvis operator if / else

        val titre: String = "Titre"

        val size = if (titre != null) titre.length else 0
        //Equivalent elvis operator
        val sizeElvis = titre?.length ?: 0
    }
}
