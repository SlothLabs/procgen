package com.github.slothLabs.procGen.maps.delaunay

/**
 * Created by mcory on 3/18/16.
 */
internal class EdgeReorderer() {
    var edges: MutableList<Edge>? = null;
    val edgeOrientations: MutableList<LR> = mutableListOf();

    constructor(origEdges: List<Edge>, criterion: ReorderCriterion) : this() {
        if (origEdges.isNotEmpty()) {
            this.edges = reorderEdges(origEdges, criterion)
        }
    }

    private fun reorderEdges(origEdges: List<Edge>, criterion: ReorderCriterion): MutableList<Edge> {
        val n = origEdges.size

        var done = BooleanArray(n)
        var numDone = 0

        for (i in 0..done.size - 1) done[i] = false

        val newEdges: MutableList<Edge> = mutableListOf()

        var i = 0

        var edge = origEdges[i]

        newEdges.add(edge)
        edgeOrientations.add(LR.LEFT)

        var firstPoint: Coord? = when(criterion) {
            ReorderCriterion.VERTEX -> edge.leftVertex
            else -> edge.leftSite
        }

        var lastPoint: Coord? = when(criterion) {
            ReorderCriterion.VERTEX -> edge.rightVertex
            else -> edge.rightSite
        }

        if (firstPoint == Vertex.VertexAtInfinity || lastPoint == Vertex.VertexAtInfinity) return mutableListOf()

        done[i] = true
        numDone++

        while (numDone < n) {
            for (i in 1 .. n - 1) {
                if (done[i]) continue
                edge = origEdges[i]
                val leftPoint: Coord? = when(criterion) {
                    ReorderCriterion.VERTEX -> edge.leftVertex
                    else -> edge.leftSite
                }

                val rightPoint: Coord? = when(criterion) {
                    ReorderCriterion.VERTEX -> edge.rightVertex
                    else -> edge.rightSite
                }

                if (leftPoint == Vertex.VertexAtInfinity || rightPoint == Vertex.VertexAtInfinity) return mutableListOf()

                if (leftPoint == lastPoint) {
                    lastPoint = rightPoint
                    edgeOrientations.add(LR.LEFT)
                    newEdges.add(edge)
                    done[i] = true
                } else if (rightPoint == firstPoint) {
                    firstPoint = leftPoint
                    edgeOrientations.remove()
                }
            }
        }
    }
}

internal enum class ReorderCriterion {
    VERTEX, SITE;
}