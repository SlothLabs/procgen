package kotlin.com.github.slothLabs.procGen.maps.geometry

import com.github.slothLabs.procGen.maps.geometry.Point

/**
 * Created by mcory on 3/17/16.
 */
class LineSegment(val p1: Point, val p2: Point) {

    val length = p1.distanceTo(p2);

    fun compareLengthsMax(other: LineSegment): Int {
        if (length < other.length) {
            return 1;
        }

        if (length > other.length) {
            return -1;
        }

        return 0;
    }

    fun compareLengths(other: LineSegment): Int {
        return -1 * compareLengthsMax(other)
    }
}