package com.github.slothLabs.procGen.maps.delaunay

import com.github.slothLabs.procGen.maps.geometry.Point
import java.util.*

/**
 * Created by mcory on 3/17/16.
 */
class Site(val p: Point, val index: Int, val weight: Double, val color: Double) : Coord{
    val edges: MutableList<Edge> = mutableListOf();
    val edgeOrientations: MutableList<LR> = mutableListOf();
    val region: MutableList<Point> = mutableListOf();

    fun addEdge(edge: Edge) {
        edges.add(edge)
    }

    override val coords: Point
        get() = p

    fun nearestEdge(): Edge {
        edges.sortBy { it.sitesDistance };
        return edges[0];
    }

    fun neighborSites(): List<Site> {
        if (edges.isEmpty()) return listOf();

        if (edgeOrientations.isEmpty()) reorderEdges();

        return listOf()
    }

    private fun neighborSite(edge: Edge): Site? {
        when(this) {
            edge.leftSite -> return edge.rightSite;
            edge.rightSite -> return edge.leftSite;
            else -> return null;
        }
    }

    private fun reorderEdges() {

    }

    companion object Comparisons {
        fun compareSitesDistances_MAX(edge0: Edge, edge1: Edge): Int {
            val len0 = edge0.sitesDistance;
            val len1 = edge1.sitesDistance;
            if (len0 < len1) {
                return 1;
            }

            if (len0 > len1) {
                return -1;
            }

            return 0;
        }

        fun compareSitesDistances(edge0: Edge, edge1: Edge): Int {
            return -compareSitesDistances_MAX(edge0, edge1);
        }
    }
}