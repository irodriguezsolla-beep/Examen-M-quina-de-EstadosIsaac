package org.example

import org.example.Estados.Idle
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {

    @BeforeTest
    fun resetMachineBeforeTest() {
        resetMachine()
    }

    @AfterTest
    fun resetMachineAfterTest() {
        resetMachine()
    }

    @Test
    fun testIdle_MovingUp() {
        Gestor.currentState = Estados.Idle
        Gestor.tocar = true
        Gestor.boton = BotoneraInterior.Piso1
        val siguienteEstado = Gestor.gestorEstados()
        assertEquals(Estados.MovingUp, siguienteEstado)
    }

    @Test
    fun testIdle_Error() {
        Gestor.currentState = Estados.Idle
        Gestor.tocar = true
        Gestor.boton = null
        val siguienteEstado = Gestor.gestorEstados()
        assertEquals(Estados.Error, siguienteEstado)
    }

    @Test
    fun MovingUP_idle() {
        Gestor.currentState = Estados.MovingUp
        Gestor.boton = BotoneraInterior.Piso1
        val siguienteEstado = Gestor.gestorEstados()
        assertEquals(Estados.Idle, siguienteEstado)
    }
    @Test
    fun MovingUP_Error() {
        Gestor.currentState = Estados.MovingUp
        Gestor.boton = null
        val siguienteEstado = Gestor.gestorEstados()
        assertEquals(Estados.Error, siguienteEstado)
    }

    @Test
    fun MovingDOWN_idle() {
        Gestor.currentState = Estados.MovingDOWN
        Gestor.boton = BotoneraInterior.Piso0
        val siguienteEstado = Gestor.gestorEstados()
        assertEquals(Estados.Idle, siguienteEstado)
    }
    @Test
    fun EsMovingDOWN() {
        Gestor.currentState = Estados.MovingDOWN
        Gestor.boton = null
        val siguienteEstado = Gestor.gestorEstados()
        assertEquals(Estados.Error, siguienteEstado)
    }


    private fun resetMachine() {
        Gestor.boton = null
        Gestor.tocar = true
        Gestor.currentState = Idle
    }
}