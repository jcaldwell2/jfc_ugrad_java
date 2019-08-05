import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * @author James Caldwell
 * @version 3/23/2016
 * CarShape.java -- Car shape
 */

/**
 * A car that can be moved around.
 */
public class CarShape implements MoveableShape {


    private int x;
    private int y;
    private int width;
    private int dx;
    private int dy;

    /**
     * Constructs a car item.
     *
     * @param x     the left of the bounding rectangle
     * @param y     the top of the bounding rectangle
     * @param width the width of the bounding rectangle
     * @param _dx   the dx
     * @param _dy   the dy
     */
    public CarShape(int x, int y, int width, int _dx, int _dy) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.dx = _dx;
        this.dy = _dy;
    }

    @Override
    public int getDx() {
        return this.dx;
    }

    @Override
    public void setDx(int dx) {
        this.dx = dx;
    }

    @Override
    public int getDy() {
        return this.dy;
    }

    @Override
    public void setDy(int dy) {
        this.dy = dy;
    }

    /**
     * Translate.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;


    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Draw.
     *
     * @param g2 the g 2
     */
    public void draw(Graphics2D g2) {
        Rectangle2D.Double body
                = new Rectangle2D.Double(x, y + width / 6,
                width - 1, width / 6);
        Ellipse2D.Double frontTire
                = new Ellipse2D.Double(x + width / 6, y + width / 3,
                width / 6, width / 6);
        Ellipse2D.Double rearTire
                = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3,
                width / 6, width / 6);

        // The bottom of the front windshield
        Point2D.Double r1
                = new Point2D.Double(x + width / 6, y + width / 6);
        // The front of the roof
        Point2D.Double r2
                = new Point2D.Double(x + width / 3, y);
        // The rear of the roof
        Point2D.Double r3
                = new Point2D.Double(x + width * 2 / 3, y);
        // The bottom of the rear windshield
        Point2D.Double r4
                = new Point2D.Double(x + width * 5 / 6, y + width / 6);
        Line2D.Double frontWindshield
                = new Line2D.Double(r1, r2);
        Line2D.Double roofTop
                = new Line2D.Double(r2, r3);
        Line2D.Double rearWindshield
                = new Line2D.Double(r3, r4);

        g2.draw(body);
        g2.draw(frontTire);
        g2.draw(rearTire);
        g2.draw(frontWindshield);
        g2.draw(roofTop);
        g2.draw(rearWindshield);
    }

}
