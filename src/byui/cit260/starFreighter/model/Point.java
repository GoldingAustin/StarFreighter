package byui.cit260.starFreighter.model;

import java.io.Serializable;

/**
 * A simple representation of a pair of coordinates.
 */
public class Point implements Serializable {
    /**
     * Class properties.
     */
    public final int x;
    public final int y;

    /**
     * Class constructor. Sets the internal coordinates.
     * @param x
     * @param y 
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.x;
        hash = 37 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}
