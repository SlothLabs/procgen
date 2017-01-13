package com.github.slothLabs.procGen.maps.delaunay

/**
 * Created by mcory on 3/18/16.
 */
enum class LR(val lrName: String) {
    LEFT("left"),
    RIGHT("right");

    fun other(): LR {
        when (this) {
            LEFT -> return RIGHT;
            else -> return LEFT;
        }
    }

    override fun toString(): String {
        return lrName;
    }
}