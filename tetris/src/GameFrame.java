import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame  extends JFrame implements KeyListener {

    // CONSTANTS
    public final int G_WIDTH = 200;
    public final int G_HEIGHT = 400;
    public final int TP_WIDTH = G_WIDTH * 2;
    public final int TP_HEIGHT = G_HEIGHT * 2;
    public final Dimension SIZE = new Dimension(300, 600);
    public final int CELLSIZE = (G_WIDTH / 10);
    public final int WIDTH_CELL= G_WIDTH / CELLSIZE;
    public final int HEIGHT_CELL = G_HEIGHT / CELLSIZE;

    // CURRENT SHAPE VARIABLES
    public int currX = 4;
    public int currY = 4;
    public Shape current = Shape.TShape;

    // SWING COMPONENTS

    public JPanel topPanel = new JPanel();
    public JPanel gamePanel = new JPanel() {
        @Override
        public void paint(Graphics g) {
            // Set background
            g.setColor(Color.black);
            g.fillRect(0, 0, G_WIDTH, G_HEIGHT);

            // Fill in grid
            for(int row = 0; row < WIDTH_CELL; row++) {
                for(int col = 0; col < HEIGHT_CELL; col++) {
                    g.setColor(Color.gray);
                    g.drawRect((CELLSIZE*row), (CELLSIZE*col), CELLSIZE, CELLSIZE);
                }
            }

            // Generate values
            //int x = WIDTH_CELL/2;
            //int y = HEIGHT_CELL/2;

            // Get random block
            //int choice = (int)(Math.random() * Shape.numOfShapes);

            // Draw shape
            drawShape(g, currX, currY, current);
        }
    };

    GameFrame() {
        // GameFrame
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(G_WIDTH, G_HEIGHT);
        this.add(gamePanel);
        this.setBackground(Color.GRAY);

        // GamePanel
        gamePanel.setVisible(true);
        gamePanel.setBackground(Color.BLACK);
        gamePanel.setSize(G_WIDTH, G_HEIGHT);
    }

    public void drawShape(Graphics g, int x, int y, Shape s) {
        // Initialize
        x -= 1;
        y -= 1;
        Color c = s.getColor();
        int[][] offset = s.getCoords();

        // Colour should depend on type of Shape
        g.setColor(c);

        // Fill Shape with according offsets, offset account for Shape and orientation
        g.fillRect((CELLSIZE *x) + CELLSIZE *offset[0][0], (CELLSIZE *y) + CELLSIZE *offset[1][0], CELLSIZE, CELLSIZE);
        g.fillRect((CELLSIZE *x) + CELLSIZE *offset[0][1], (CELLSIZE *y) + CELLSIZE *offset[1][1], CELLSIZE, CELLSIZE);
        g.fillRect((CELLSIZE *x) + CELLSIZE *offset[0][2], (CELLSIZE *y) + CELLSIZE *offset[1][2], CELLSIZE, CELLSIZE);
        g.fillRect((CELLSIZE *x) + CELLSIZE *offset[0][3], (CELLSIZE *y) + CELLSIZE *offset[1][3], CELLSIZE, CELLSIZE);
    }

    public void setCurrX(int x) {
        currX = x;
    }

    public void setCurrY(int y) {
        currY = y;
    }

    public void setShape(Shape s) {
        current = s;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
