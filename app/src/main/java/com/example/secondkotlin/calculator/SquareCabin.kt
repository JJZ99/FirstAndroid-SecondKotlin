package com.example.secondkotlin.calculator


/**
 * A square cabin dwelling.
 *
 *  @param residents Current number of residents
 *  @param length Length
 */
class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
     override val buildingMaterial = "Wood"
     override val capacity = 6

    /**
     * Calculates floor area for a square dwelling.
     *
     * @return floor area
     */
    override fun floorArea(): Double {
        return length * length
    }
    init {
        print("dsadasda")
    }

}


