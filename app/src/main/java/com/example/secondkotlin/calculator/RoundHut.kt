package com.example.secondkotlin.calculator

import java.lang.Math.PI
import java.lang.Math.sqrt

/**
 * Dwelling with a circular floorspace
 *
 * @param residents Current number of residents
 * @param radius Radius
 */
open class RoundHut(
    val residents: Int, val radius: Double) : Dwelling(residents) {

     override val buildingMaterial = "Straw"
     override val capacity = 4

    /**
     * Calculates floor area for a round dwelling.
     *
     * @return floor area
     */
    override fun floorArea(): Double {
        return PI * radius * radius
    }

    /**
     *  Calculates the max length for a square carpet
     *  that fits the circular floor.
     *
     * @return length of carpet
     */
    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }

}
