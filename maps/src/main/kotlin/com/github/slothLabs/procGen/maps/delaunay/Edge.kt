package com.github.slothLabs.procGen.maps.delaunay

import kotlin.com.github.slothLabs.procGen.maps.geometry.LineSegment

/**
 * Created by mcory on 3/18/16.
 */
class Edge(val leftSite: Site, val rightSite: Site, val a: Double, val b: Double, val c: Double, var leftVertex: Vertex? = null, var rightVertex: Vertex? = null) {

    val delaunayLine: LineSegment by lazy {
        LineSegment(leftSite.p, rightSite.p);
    }

    val sitesDistance: Double by lazy {
        leftSite.p.distanceTo(rightSite.p);
    }

    fun vertex(leftRight: LR): Vertex? {
        when (leftRight) {
            LR.LEFT -> return this.leftVertex;
            else -> return this.rightVertex;
        }
    }

    fun setVertex(leftRight: LR, vertex: Vertex?) {
        when (leftRight) {
            LR.LEFT -> this.leftVertex = vertex;
            else -> this.rightVertex = vertex;
        }
    }

    fun isPartOfConvexHull(): Boolean = this.leftVertex == null || this.rightVertex == null


    companion object Factory {
        fun createBisectingEdge(site0: Site, site1: Site): Edge {

            val dx = site1.p.x - site0.p.x;
            val dy = site1.p.y - site0.p.y;

            val absdx = Math.abs(dx);
            val absdy = Math.abs(dy);

            val tempC = (site0.p.x * dx) + (site0.p.y * dy) + ((dx * dx) + (dy * dy)) * 0.5;

            val a: Double;
            val b: Double;
            val c: Double;
            if (absdx > absdy) {
                a = 1.0;
                b = dy / dx;
                c = tempC / dx;
            } else {
                b = 1.0;
                a = dx / dy;
                c = tempC / dy;
            }

            val res = Edge(site0, site1, a, b, c);

            site0.addEdge(res);
            site1.addEdge(res);
            return res;
        }
    }
}