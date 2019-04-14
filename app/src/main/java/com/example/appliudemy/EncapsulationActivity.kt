package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

/*TODO private, protected, public(defaut) et internal(propre au kotlin accès au module)*/

open class Account{
    protected var balance: Int = 0

    open fun deposit(value: Int){
        balance += value
        val prefix = if(value >= 0) "+" else ""
        println("$prefix $value € sur le compte, nouveau solde : $balance €")
    }
}

class PositiveAccount : Account(){

    override fun deposit(value: Int) {
        if(!isValidDeposit(value)){
            println("Opération interdite !")
            return
        }
        super.deposit(value)
    }

    private fun isValidDeposit(value: Int) : Boolean{
        return balance + value >= 0
    }
}

class EncapsulationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encapsulation)

        println("Compte normal")
        val account = Account()
        account.deposit(50)
        account.deposit(-100)

        println("Compte positif")
        val positiveAccount = PositiveAccount()
        positiveAccount.deposit(42)
        positiveAccount.deposit(-100)
        positiveAccount.deposit(-10)

    }
}
