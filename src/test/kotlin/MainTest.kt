package org.example

import kotlin.test.BeforeTest
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals
class MainTest {
    @BeforeTest
    fun resetMachineBeforeTest(resetMachine: () -> Unit) {
        resetMachine()
    }

    @AfterTest
    fun resetMachineAfterTest(resetMachine: () -> Unit) {
        resetMachine()
    }



    @Test
    fun testIdle_MovingUp(){
        Gestor.currentState = Estados.Idle
        Gestor.tocar = true
        Gestor.boton = BotoneraInterior.Piso1
        val siguienteEstado = Gestor.gestorEstados()
        assertEquals(Estados.MovingUp, siguienteEstado)

    }
    @Test
    fun MovingUP_idle(){

        Gestor.currentState = Estados.MovingUp
        Gestor.boton = BotoneraInterior.Piso1
        val siguienteEstado = Gestor.gestorEstados()
        assertEquals(Estados.Idle, siguienteEstado)
    }
}