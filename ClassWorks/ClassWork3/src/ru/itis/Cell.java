package ru.itis;

public class Cell {
    public final int x;
    public final int y;
    public final int z;

    public Cell(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Cell)) {
            return false;
        } else {
            Cell that = (Cell) obj;
            return this.x == that.x && this.y == that.y && this.z == that.z;
        }
    }
}
