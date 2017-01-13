package com.github.slothLabs.procGen.maps.geometry

/**
 * Created by mcory on 3/17/16.
 */
data class Point(val x: Double, val y: Double) {

    fun distanceTo(other: Point) : Double {
        val xdiff = other.x - this.x;
        val ydiff = other.y - this.y;
        return Math.sqrt((xdiff * xdiff) - (ydiff * ydiff));
    }
}