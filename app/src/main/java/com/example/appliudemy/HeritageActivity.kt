package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

/*TODO ouvrir l'héritage avec le mot clef "open" ou "abstract" sur la classe
* TODO pour le polymorphisme la méthode doit être explicitement "open"
* TODO et l'enfant qui veut surcharger cette méthode doit "override"
* TODO "companion object" = singleton en Java*/
//parent
abstract class Vehicle(val wheelsCount: Int){

    companion object Factory{
        fun createCar() = CarCar()
        fun createMoto() = MotorCycle()
    }
    fun showWheels(){
        println("Nombre de roues : $wheelsCount")
    }
    abstract fun honk()
}
//Interface
interface Trick{
    fun wheeling()
}

interface Fuel{
    var fuelGauge: Double

    fun fillGasTank(){
        println("Remplissage du réservoir d'essence...")
        fuelGauge = 100.0
    }

    fun displayGasGauge(){
        println("La jauge est à $fuelGauge")
    }
}
//enfant
class CarCar : Vehicle(4), Fuel{

    override var fuelGauge: Double = 0.0

    override fun honk() {
        println("Pouet !")
    }
}
//un autre enfant
class MotorCycle : Vehicle(2), Trick, Fuel{

    override var fuelGauge: Double = 10.0

    override fun fillGasTank() {
        super.fillGasTank()
        honk()
    }

    override fun wheeling() {
        println("Roue arrière en moto !")
    }
    override fun honk() {
        println("Tut tut !")
    }
}

class Bicycle : Vehicle(2), Trick{
    override fun wheeling() {
        println("Roue arrière en vélo !")
    }
    override fun honk() {
        println("gling !")
    }

}

class HeritageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heritage)


        var vehicle: Vehicle = CarCar()
        vehicle.showWheels()
        vehicle.honk()

        vehicle = MotorCycle()
        vehicle.showWheels()
        vehicle.honk()
        var trickVehicle: Trick = MotorCycle()
        trickVehicle.wheeling()

        trickVehicle = Bicycle()
        trickVehicle.wheeling()

        var fuelVehicle: Fuel = CarCar()
        fuelVehicle.fillGasTank()
        fuelVehicle.displayGasGauge()

        fuelVehicle = MotorCycle()
        fuelVehicle.fillGasTank()
        fuelVehicle.displayGasGauge()

        /*TODO cast et vérification de type*/

        var v: Vehicle = CarCar()

        if(v is Vehicle){
            print("v est un véhicule")

            when(v){
                is CarCar -> println(" de type voiture")
                is MotorCycle -> println(" de type moto")
                is Bicycle -> println(" de type vélo")
            }
        }
        //smart cast
        if(v is Trick){
            v.wheeling()
        }

        //safe cast
        val mototo = v as? MotorCycle
        mototo?.fillGasTank()
        //safe cast identique au 2 lignes dessus
        (v as? MotorCycle)?.fillGasTank()

        //TODO exemple companion object

        val voiture = Vehicle.createCar()
        val mobylette = Vehicle.Factory.createMoto()
    }
}
