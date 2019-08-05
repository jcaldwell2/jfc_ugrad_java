import java.awt.*;
/**
 * @author James Caldwell
 * @version 3/23/2016
 * MoveableShape.java -- Moveable Shape interface
 */


/**
 * A shape that can be moved around.
 */
public interface MoveableShape {
    /**
     * Draws the shape.
     *
     * @param g2 the graphics context
     */
    void draw(Graphics2D g2);

    /**
     * Moves the shape by a given amount.
     *
     * @param dx the amount to translate in x-direction
     * @param dy the amount to translate in y-direction
     */
    void translate(int dx, int dy);

    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    int getWidth();

    int getDx();

    void setDx(int dx);

    int getDy();

    void setDy(int dy);


}
