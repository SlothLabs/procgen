package com.github.slothLabs.procGen.maps.geometry

/**
 * Created by mcory on 3/17/16.
 */
enum class Winding(val windingName: String) {
    CLOCKWISE("clockwise"),
    COUNTERCLOCKWISE("counterclockwise"),
    NONE("none");

    override fun toString() : String {
        return windingName;
    }
}