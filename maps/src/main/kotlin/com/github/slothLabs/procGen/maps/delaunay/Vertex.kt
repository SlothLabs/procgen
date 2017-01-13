package com.github.slothLabs.procGen.maps.delaunay

import com.github.slothLabs.procGen.maps.geometry.Point

/**
 * Created by mcory on 3/18/16.
 */
class Vertex(val p: Point, val index: Int) : Coord {
    override val coords: Point
        get() = p

    companion object {
        val VertexAtInfinity = Vertex(Point(Double.NaN, Double.NaN), Int.MIN_VALUE)
    }
}

