package com.example.secondkotlin.calculator

class RoundTower(residents: Int, radius: Double, val floors: Int = 2) :
    RoundHut(residents, radius) {
    override val capacity = floors * 4
    override val buildingMaterial = "Store"

    override fun floorArea():Double{
        return super.floorArea() * floors

    }






}