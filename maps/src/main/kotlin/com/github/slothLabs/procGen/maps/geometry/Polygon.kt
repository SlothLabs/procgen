package com.github.slothLabs.procGen.maps.geometry

/**
 * Created by mcory on 3/17/16.
 */
class Polygon(val vertices: List<Point>) {

    fun area(): Double {
        return Math.abs(signedDoubleArea() * 0.5);
    }

    fun winding(): Winding {
        val sda = signedDoubleArea();
        when {
            sda == 0.0 -> return Winding.NONE
            sda < 0.0 -> return Winding.CLOCKWISE
            else -> return Winding.COUNTERCLOCKWISE
        }
    }

    private fun signedDoubleArea(): Double {
        val n = vertices.size;
        var signedDoubleArea = 0.0;
        for (index in 0..vertices.size - 1) {
            val nextIndex = (index + 1) % n;
            val point = vertices[index];
            val nextPoint = vertices[nextIndex];
            signedDoubleArea += point.x * nextPoint.y - nextPoint.x * point.y;
        }

        return signedDoubleArea;
    }
}