package org.example

import org.example.Gestor.boton
import org.example.Gestor.currentState
import org.example.Gestor.tocar

sealed class Estados {
    abstract fun onEnter()

    object Idle : Estados() {
        override fun onEnter() {
            println("Entrando al estado Idle")
            Thread.sleep(2000)
            val b = boton

            if (!tocar || b == null) {
                if (!tocar) println("Opción elegida: No toco nada")
                currentState = Error
            } else if (b.piso > 0) {
                println("Subiendo")
                currentState = MovingUp
            } else {
                println("Bajando")
                currentState = MovingDOWN
            }
        }

        override fun toString(): String = "Idle"
    }

    object MovingUp : Estados() {
        override fun onEnter() {
            val b = boton
            if (b != null && b.piso == 1) {
                println("Entrando al estado MOVING UP")
                println("Preparando Subiendo....")
                Thread.sleep(2000)
                currentState = Idle
            } else {
                currentState = Error
            }
        }

        override fun toString(): String = "MovingUp"
    }

    object MovingDOWN : Estados() {
        override fun onEnter() {
            val b = boton
            if (b != null && b.piso == 0) {
                println("Entrando al estado MOVING DOWN")
                println("Preparando Bajando....")
                Thread.sleep(2000)
                currentState = Idle
            } else {
                currentState = Error
            }
        }

        override fun toString(): String = "MovingDOWN"
    }

    object Error : Estados() {
        override fun onEnter() {
            println("Error")
        }

        override fun toString(): String = "Error"
    }
}