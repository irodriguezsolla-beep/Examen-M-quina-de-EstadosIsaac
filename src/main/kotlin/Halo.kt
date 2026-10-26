package org.example

import org.example.Estado.*
import kotlin.toString

object Halo {
    var boton: BotoneraInterior? = null
    var currentState: Estado = Idle
    var tocar: Boolean = true
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