package com.example.appliudemy

data class Employe(val name: String, val age: Int) {

    companion object{
        fun createBob() = Employe("Bob", 32)
    }
}