package org.example
import org.example.Estado.Idle
import org.example.Estado.MovingUp
import org.example.Estado.MovingDOWN
import org.example.Estado.Error
import kotlin.toString

class Halo {
    var currentState: Estado = Idle
    fun gestorEstados(): Estado{
        println("-------------------------------")
        println("Estado actual: ${currentState.toString()}")
        when(currentState){
            is Idle -> {
                (currentState as Idle).onEnter()
            }
            is MovingUp -> {
                (currentState as MovingUp).onEnter()
            }
            is MovingDOWN ->{
                (currentState as MovingDOWN).onEnter()
            }
            is Error -> {
                (currentState as Error).onEnter()
            }
        }
        return currentState

    }
}