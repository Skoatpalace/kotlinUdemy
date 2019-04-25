package com.example.appliudemy

import android.graphics.Color
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.io.File

data class Prof(var name: String = "", var age: Int = 0)

fun createDirectory(path: String): File{
    val file = File(path)
    file.mkdir()
    return file
}

class ApplyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)

        val longProf = Prof()
        longProf.name = "Georges"
        longProf.age = 58
        println("$longProf")

        //avec apply

        val shortProf = Prof().apply {
            name = "Jeanne"
            age = 30
        }
        println("$shortProf")

        val longHome = createDirectory("home")

        //fun createDirectory() remplacé apr apply

        val shortHome = File("shortHome").apply { mkdir() }

        //TODO utilisation de with

        val paint = Paint()
        paint.alpha = 100
        paint.color = Color.RED
        paint.strokeWidth = 2.0f

        //est égale à :
        with(paint){
            alpha = 100
            color = Color.CYAN
            strokeWidth = 1.0f
        }

        //TODO utilisation de Run (let + with)

        val sb = StringBuilder()
        sb.append("hello")
        sb.append("Kotlin")

        val sentence = sb.toString()
        println(sentence)

        val shorterSentence = StringBuilder().run {
            append("hello")
            append("run roxx !")
            toString()
        }

        println("$shorterSentence")

    }
}
