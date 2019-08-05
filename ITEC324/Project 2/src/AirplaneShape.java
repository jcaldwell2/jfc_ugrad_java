/**
 * @author James Caldwell
 * @version 3/23/2016
 * BoatShape.java - Boat shape
 */

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


/**
 * A boat that can be moved around.
 */
public class AirplaneShape implements MoveableShape {


    private int x;
    private int y;
    private int width;
    private int dx;
    private int dy;

    /**
     * Instantiates a new Airplane shape.
     *
     * @param x     the x
     * @param y     the y
     * @param width the width
     * @param _dx   the dx
     * @param _dy   the dy
     */
    public AirplaneShape(int x, int y, int width, int _dx, int _dy) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.dx = _dx;
        this.dy = _dy;
    }

    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getWidth() {
        return width;
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

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics2D g2) {


        Rectangle2D.Double body
                = new Rectangle2D.Double(x, y + width / 6,
                width - 1, width / 6);

        Rectangle2D.Double rightWing
                = new Rectangle2D.Double(x + 50, y + 25,
                width - 80, width / 2.5);
        Rectangle2D.Double leftWing
                = new Rectangle2D.Double(x + 50, y - 17,
                width - 80, width / 3);
        Rectangle2D.Double rudders
                = new Rectangle2D.Double(x, y,
                width - 90, width / 6);


        Point2D.Double r1
                = new Point2D.Double(x + width / 6, y + width / 6);

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


        g2.setPaint(Color.green);
        g2.fill(body);
        g2.draw(body);
        g2.setPaint(Color.red);
        g2.fill(rightWing);
        g2.draw(rightWing);
        g2.fill(rudders);
        g2.draw(rudders);
        g2.setPaint(Color.blue);
        g2.fill(leftWing);
        g2.draw(leftWing);

    }
}
