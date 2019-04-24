package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlin.ArithmeticException
import kotlin.NullPointerException

//function pour déclencher l'exception !! force l'operation
fun divide(numerator: Int?, denominator: Int?): Int{
    try {
        return  numerator!! / denominator!!
    }catch (e: NullPointerException){
        throw DivideException("Division par 0 interdite", e)
    }catch (ae: ArithmeticException){
        throw DivideException("Operande null", ae)
    }

}
class DivideException(message: String, cause: Exception)
    : Exception(message, cause)


class ExceptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exception)

        val numerator: Int? = null
        val denominator = 2

        try {
            divide(numerator, denominator)
        }catch (e: DivideException){
            println("${e.message} cause : ${e.cause}")
        }finally {
            println("Fin de l'opération")
        }
    }
}
