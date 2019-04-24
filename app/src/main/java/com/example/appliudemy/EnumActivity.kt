package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

enum class Direction(val description: String){
    NORTH("Nord"){
        override fun action() = "Marcher"
    },
    EAST("Est"){
        override fun action() = "Courir"
    },
    WEST("Ouest"){
        override fun action() = "Sauter"
    },
    SOUTH("Sud"){
        override fun action() = "Se reposer"
    };

    abstract fun action(): String

    override fun toString(): String {
        return "$name (description = $description, action = ${this.action()}"
    }
}

fun logAtion(windDirection: Direction){
    val action = when(windDirection){
        Direction.NORTH -> "Marcher"
        Direction.EAST -> "Courir"
        Direction.WEST -> "Sauter"
        Direction.SOUTH -> "Se reposer"
    }
    println("Vent du ${windDirection.description}, action = $action")
}

class EnumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enum)

        val windDirection = Direction.NORTH
        logAtion(windDirection)

        println("Direction.action() -> ${windDirection.action()}")

        val southName = Direction.SOUTH.name
        val southOrdinal = Direction.SOUTH.ordinal

        println("${Direction.SOUTH}: name = $southName, ordinal = $southOrdinal")

        val southDirection: Direction = Direction.valueOf(southName)
        val southFromOrdinal: Direction = Direction.values()[southOrdinal]

        for (direction in Direction.values()){
            println(direction)
        }
    }
}
