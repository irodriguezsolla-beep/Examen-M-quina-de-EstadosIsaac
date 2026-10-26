package org.example

import org.example.Estados.*

object Gestor {
    var boton: BotoneraInterior? = null
    public var currentState: Estados = Idle
    var tocar: Boolean = true
    fun gestorEstados(): Estados{
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