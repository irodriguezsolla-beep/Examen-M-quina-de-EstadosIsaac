package org.example

import  org.example.Halo.tocar
import  org.example.Halo.boton
import  org.example.Halo.currentState

sealed class Estado {


    object Idle : Estado() {
        fun onEnter() {
            println("Entrando al estado E1_Idle")

            println("Entrando al estado E4_SeleccionAzucar")
            Thread.sleep(2000)
            val b = boton
            // Verifica si el usuario indicó que no quiere subir.
            if (!tocar) {
                println("Opción elegida: No toco nada")

                currentState = Error
            } else {

                if (b != null && b.piso > 0) {
                    println("Subiendo")

                    currentState =  MovingUp
                } else {

                    currentState = MovingDOWN
                }
            }
        }

        override fun toString(): String {
            return "E1_Idle"
        }
    }
    object MovingUp : Estado() {
        fun onEnter() {
            val b = boton
            if(b != null && b.piso == 1) {
                println("Entrando al estado MOVING UP")
                println("Preparando Subiendo....")
                Thread.sleep(2000)
                currentState = Idle
            }else{
                currentState = Error
            }
        }

        override fun toString(): String {
            return "MovingUp"
        }
    }
    object MovingDOWN : Estado() {
        fun onEnter() {
            val b = boton
            if(b != null && b.piso == 0) {
                println("Entrando al estado MOVING DOWN")
                println("Preparando Bajando....")
                Thread.sleep(2000)
                currentState = Idle
            }else{
                currentState = Error

            }
        }

        override fun toString(): String {
            return "MovingUp"
        }
    }
    object Error : Estado() {
        fun onEnter() {
            println("Error")

        }

        override fun toString(): String {
            return "Error"
        }
    }

}