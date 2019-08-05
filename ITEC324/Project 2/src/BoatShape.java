
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * @author James Caldwell
 * @version 3/23/2016
 * BoatShape.java -- Boat shape class
 */


/**
 * A boat that can be moved around.
 */
public class BoatShape implements MoveableShape {

    private int x;
    private int y;
    private int width;
    private int dx;
    private int dy;


    /**
     * Constructs a boat item.
     *
     * @param x     the left of the bounding rectangle
     * @param y     the top of the bounding rectangle
     * @param width the width of the bounding rectangle
     * @param _dx   the dx
     * @param _dy   the dy
     */
    public BoatShape(int x, int y, int width, int _dx, int _dy) {
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


        // The the first point at the rght of the boat on the top
        Point2D.Double r1
                = new Point2D.Double(x + width / 6, y + width / 3);

        // The back left point of the top of the boat
        Point2D.Double r2
                = new Point2D.Double(x + width, y + width / 3);
        // The bottom left point of the boat
        Point2D.Double r3
                = new Point2D.Double(x + width / 2, y + width * 2 / 4);
        // The bottom of the right of the boat
        Point2D.Double r4
                = new Point2D.Double(x + width / 4, y + width * 2 / 4);
        // The top point of the mast
        Point2D.Double r5
                = new Point2D.Double(x + width / 3, y + width / 50);
        // The bottom point of the mast
        Point2D.Double r6
                = new Point2D.Double(x + width / 3, y + width / 3);
        // The left point of the sails
        Point2D.Double r7
                = new Point2D.Double(x + width * 2 / 20, y + width * 2 / 8);
        // The right point of the sails
        Point2D.Double r8
                = new Point2D.Double(x + width * 3 / 4, y + width * 2 / 8);


        Line2D.Double boatTop
                = new Line2D.Double(r1, r2);
        Line2D.Double boatBack
                = new Line2D.Double(r2, r3);
        Line2D.Double boatBottom
                = new Line2D.Double(r3, r4);
        Line2D.Double boatFront
                = new Line2D.Double(r4, r1);
        Line2D.Double mast
                = new Line2D.Double(r5, r6);
        Line2D.Double leftSail
                = new Line2D.Double(r5, r7);
        Line2D.Double bottomSail
                = new Line2D.Double(r7, r8);
        Line2D.Double rightSail
                = new Line2D.Double(r8, r5);

        // Paint the boat blue
        g2.setPaint(Color.blue);

        g2.draw(boatTop);
        g2.draw(boatBack);
        g2.draw(boatBottom);
        g2.draw(boatFront);

        // Paint the mast black
        g2.setPaint(Color.black);

        g2.draw(mast);

        // Paint the sails red
        g2.setPaint(Color.red);

        g2.draw(leftSail);
        g2.draw(bottomSail);
        g2.draw(rightSail);
    }
}
