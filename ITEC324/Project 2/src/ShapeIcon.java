import java.awt.*;
import java.util.*;
import javax.swing.*;
/**
 * @author James Caldwell
 * @version 3/23/2016
 */


/**
 * An icon that contains a moveable shape.
 */
public class ShapeIcon implements Icon {
    private int width;
    private int height;
    private ArrayList<MoveableShape> shapeArrayList = new ArrayList<>();

    /**
     * Instantiates a new Shape icon.
     *
     * @param width  the width
     * @param height the height
     */
    public ShapeIcon(int width, int height) {

        this.width = width;
        this.height = height;
    }

    /**
     * Gets icon width.
     *
     * @return the icon width
     */
    public int getIconWidth() {
        return width;
    }

    /**
     * Gets icon height.
     *
     * @return the icon height
     */
    public int getIconHeight() {
        return height;
    }

    /**
     * Paint icon.
     *
     * @param c the c
     * @param g the g
     * @param x the x
     * @param y the y
     */
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        for (MoveableShape s : shapeArrayList) {
            s.draw(g2);
        }
    }

    /**
     * Translate.
     */
    public void translate() {

        for (MoveableShape s : shapeArrayList) {
            s.translate(s.getDx(), s.getDy());
            checkLoc(s);
            checkStopped(s);
        }
    }

    /**
     * Add shape.
     *
     * @param shape the shape
     */
    public void addShape(MoveableShape shape) {
        shapeArrayList.add(shape);
    }

    /**
     * Remove last.
     */
    public void removeLast() {
        if (shapeArrayList.size() > 0) {
            shapeArrayList.remove(shapeArrayList.size() - 1);
        }
    }

    /**
     * Check location of the shape and reset it accordingly.
     *
     * @param s the s
     */
    public void checkLoc(MoveableShape s) {
        if (s.getX() >= 400 + s.getWidth() && s.getDx() == 1) {
            s.setX(0 - s.getWidth());
        }

        if (s.getX() <= 0 - s.getWidth() && s.getDx() == -1) {
            s.setX(400 + s.getWidth());
        }

        if (s.getY() >= 400 + s.getWidth() / 2 && s.getDy() == 1) {
            s.setY(0 - s.getWidth() / 2);
        }

        if (s.getY() <= 0 - s.getWidth() / 2 && s.getDy() == -1) {
            s.setY(400 + s.getWidth() / 2);
        }
    }

    /**
     * Check stopped.
     *
     * @param s the s
     */
    public void checkStopped(MoveableShape s) {
        Random rand = new Random();
        int randomPick = rand.nextInt(2) + 1;

        if (s.getDx() == 0 && s.getDy() == 0) {

            if (randomPick == 1)
                s.setDx(1);

            if (randomPick == 2)
                s.setDy(1);
        }
    }


}


