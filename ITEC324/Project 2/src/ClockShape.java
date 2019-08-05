/**
 * @author James Caldwell
 * @version 3/23/2016
 * ClockShape.java - Clock Shape
 */

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


/**
 * A clock that can be moved around.
 */
public class ClockShape implements MoveableShape {

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
    public ClockShape(int x, int y, int width, int _dx, int _dy) {
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
     * Gets width.
     *
     * @return the width
     */
    @Override
    public int getWidth() {
        return this.width;
    }

    /**
     * Draw.
     *
     * @param g2 the g 2
     */
    public void draw(Graphics2D g2) {


        Ellipse2D.Double outerBody
                = new Ellipse2D.Double(x + width / 6, y + width / 3,
                width / 2, width / 2);
        Ellipse2D.Double innerBody
                = new Ellipse2D.Double(x + width / 4.8, y + width / 2.65,
                width / 2.5, width / 2.5);


        // The the first point at the center of the clock
        Point2D.Double r1
                = new Point2D.Double(x + width / 2.4, y + width * 2 / 3.5);

        // The top of the big hand
        Point2D.Double r2
                = new Point2D.Double(x + width / 2.4, y + width / 2.62);

        // The top of the small hand
        Point2D.Double r3
                = new Point2D.Double(x + width / 2, y + width / 1.5);

        Line2D.Double bigHand
                = new Line2D.Double(r1, r2);
        Line2D.Double smallHand
                = new Line2D.Double(r1, r3);

        g2.setPaint(Color.black);
        g2.draw(outerBody);
        g2.setPaint(Color.red);
        g2.fill(outerBody);
        g2.setPaint(Color.black);
        g2.draw(innerBody);
        g2.setPaint(Color.white);
        g2.fill(innerBody);
        g2.setPaint(Color.black);
        g2.draw(bigHand);
        g2.setPaint(Color.black);
        g2.draw(smallHand);

    }
}
