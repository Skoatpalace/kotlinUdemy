package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.appliudemy.common.isVisible
import com.example.appliudemy.common.toast
import java.io.File

//TODO isVisible() et toast dans ViewUtils

fun Employe.canPlayGame() = this.age > 30

fun Employe.Companion.createBobette() = Employe("Bobette", 25)
class FonctionExtensionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fonction_extension)

        val helloView = findViewById<View>(R.id.tv_extension)

        if (helloView.isVisible()){
            //Toast.makeText(this, "Text visible", Toast.LENGTH_LONG).show()
            toast("le texte est visible")
        }


        //val bob = Employe("bob", 32) fonction dans le companion object de Employe
        val bob = Employe.createBob()
        println("${bob.name} peut il jouer au jeux ? ${bob.canPlayGame()}")

        val bobette = Employe.createBobette()
        println("${bobette.name} peut il jouer au jeux ? ${bobette.canPlayGame()}")

        //utilisation de let

        File("Config").let { file ->
            if (file.exists()){
                println("$file existe")
            }else{
                file.createNewFile()
                println("$file à été crée")
            }
        }
    }
}
