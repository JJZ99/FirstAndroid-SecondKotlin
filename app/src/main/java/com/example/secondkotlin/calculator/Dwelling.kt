package com.example.secondkotlin.calculator

/**
 *指定对所有住所都适用的属性和功能——蓝图
 */
abstract class Dwelling(private var residents:Int) {

    abstract val buildingMaterial: String
    abstract val capacity: Int
        /**
         * Calculates the floor area of the dwelling.
         * Implemented by subclasses where shape is determined.
         *
         * @return floor area
         */
        abstract fun floorArea(): Double

        /**
         * Checks whether there is room for another resident.
         *
         * @return true if room available, false otherwise
         */
        fun hasRoom(): Boolean {
            return residents < capacity
        }

        /**
         * Compares the capacity to the number of residents and
         * if capacity is larger than number of residents,
         * add resident by increasing the number of residents.
         * Print the result.
         */
        fun getRoom() {
            if (capacity > residents) {
                residents++
                println("You got a room!")
            } else {
                println("Sorry, at capacity and no rooms left.")
            }
        }


}
