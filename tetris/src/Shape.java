import java.awt.*;
public class Shape {
    static int numOfShapes = 7;
    int[][] coords;
    int rotation;
    Color c;

    // Shape Offsets
    static final int[][] ISHAPE = {{0, 0, 0, 0}, {0, 1, 2, 3}};
    static final int[][] LSHAPE = {{0, 0, 0, 1}, {0, 1, 2, 2}};
    static final int[][] JSHAPE = {{0, 0, 0, -1}, {0, 1, 2, 2}};
    static final int[][] OSHAPE = {{0, 1, 0, 1}, {0, 0, 1, 1}};
    static final int[][] ZSHAPE = {{0, 1, 1, 2}, {0, 0, 1, 1}};
    static final int[][] SSHAPE = {{0, 1, 1, 2}, {0, 0, -1, -1}};
    static final int[][] TSHAPE = {{0, -1, 0, 1}, {0, 1, 1, 1}};

    // Standard Shapes
    static final Shape IShape = new Shape(Color.cyan, ISHAPE, 0);
    static final Shape LShape = new Shape(Color.orange, LSHAPE, 0);
    static final Shape JShape = new Shape(Color.blue, JSHAPE, 0);
    static final Shape OShape = new Shape(Color.yellow, OSHAPE, 0);
    static final Shape ZShape = new Shape(Color.red, ZSHAPE, 0);
    static final Shape SShape = new Shape(Color.green, SSHAPE, 0);
    static final Shape TShape = new Shape(Color.magenta, TSHAPE, 0);
    static final Shape[] Shapes = {IShape, LShape, JShape, OShape, ZShape, SShape, TShape};

    public enum Tetromino {
        IShape, LShape, JShape, OShape, ZShape, SShape, TShape
    }

    public Shape(Color c, int[][] coords, int rotation) {
        this.c = c;
        this.coords = coords;
        this.rotation = rotation;
    }

    public int[][] rotateRight(Shape s) {
        int[][] rotateRight = s.coords;
        for(int i = 0; i < s.coords[0].length; i++) {
            rotateRight[0][i] = s.coords[1][i]; // x -> y
            rotateRight[1][i] = s.coords[0][i] * -1; // y -> -(x)
        }
        return rotateRight;
    }

    public int[][] rotateLeft(Shape s) {
        int[][] rotateLeft = s.coords;
        for(int i = 0; i < s.coords[0].length; i++) {
            rotateLeft[0][i] = s.coords[1][i] * -1; // x -> -(y)
            rotateLeft[1][i] = s.coords[0][i]; // y -> x
        }
        return rotateLeft;
    }

    public int[][] getCoords() {
        return coords;
    }

    public Color getColor() {
        return c;
    }
}