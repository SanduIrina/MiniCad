package classes;
import java.util.LinkedList;
import java.util.Queue;
public final class Bresenhams {
    private Bresenhams() { };
    private static Queue<Point> queue = new LinkedList<Point>();

    // Bresenhams's algorythm for drawing lines
    public static  void draw(final Point p1, final Point p2, final int a, final String rgb,
            final Canvas canvas) {
        int x, y, deltaX, deltaY, s1, s2, ok = 0;
        int error;
        int i;
        x = p1.getX();
        y = p1.getY();
        deltaX = Math.abs(p2.getX() - p1.getX());
        deltaY = Math.abs(p2.getY() - p1.getY());
        s1 = Integer.signum(p2.getX() - p1.getX());
        s2 = Integer.signum(p2.getY() - p1.getY());
        if (deltaY > deltaX) {
            int aux = deltaY;
            deltaY = deltaX;
            deltaX = aux;
            ok = 1;
        }
        error = 2 * deltaY - deltaX;

        for (i = 0; i <= deltaX; i++) {
                canvas.changePixel(x, y, rgb, a);
            while (error > 0) {
                if (ok == 1) {
                    x += s1;
                } else {
                    y += s2;
                }
                error = error - 2 * deltaX;
            }
            if (ok == 1) {
                y += s2;
            } else {
                x += s1;
            }
            error = error + 2 * deltaY;
        }
    }

    // Bresenhams's algorythm for drawing circles
    public static void circleBres(final Circle circle, final Canvas canvas) {
        int xc = circle.getCenter().getX();
        int yc = circle.getCenter().getY();
        int r = circle.getRadius();
        int x = 0, y = r;
    // The mighty checkstyle deemes positive integers bigger than 2 a heresy
        int d = Magic.THREE - 2 * r;
        while (y >= x) {
            drawCircle(xc, yc, x, y, circle, canvas);
            x++;
            if (d > 0) {
                y--;
                d = d + Magic.FOUR * (x - y) + Magic.TEN;
            } else {
                d = d + Magic.FOUR * x + Magic.SIX;
            }
            drawCircle(xc, yc, x, y, circle, canvas);
       }
    }

    public static void drawCircle(final int xc, final int yc, final int x, final int y,
            final Circle circle, final Canvas canvas) {
        canvas.changePixel(circle.getCenter().getX(), circle.getCenter().getY(),
                circle.getRgbInt(), circle.getIntA());
        canvas.changePixel(xc + x, yc + y, circle.getRgbExt(), circle.getExtA());
        canvas.changePixel(xc + y, yc + x, circle.getRgbExt(), circle.getExtA());
        canvas.changePixel(xc - y, yc + x, circle.getRgbExt(), circle.getExtA());
        canvas.changePixel(xc - x, yc + y, circle.getRgbExt(), circle.getExtA());
        canvas.changePixel(xc - x, yc - y, circle.getRgbExt(), circle.getExtA());
        canvas.changePixel(xc - y, yc - x, circle.getRgbExt(), circle.getExtA());
        canvas.changePixel(xc + y, yc - x, circle.getRgbExt(), circle.getExtA());
        canvas.changePixel(xc + x, yc - y, circle.getRgbExt(), circle.getExtA());
    }

    /*
      Flood-fill algorythm using a queue. I enqueue the neighbors of a pixel if they are in-bound,
      are different from the color of the current shape and from the current shape's border. The
      boundary check is ensured by the changePixel method from Canvas class.
     */
    public static void floodFill(final Shape shape, final Canvas canvas) {
        queue.add(shape.getCenter());
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            canvas.changePixel(p.getX(), p.getY(), shape.getRgbInt(), shape.getIntA());
            if (canvas.getPixel(p.getX() - 1, p.getY())  != null
                && canvas.getPixel(p.getX() - 1,
                        p.getY()).getRgb().compareTo(shape.getRgbExt()) != 0
                && canvas.getPixel(p.getX() - 1,
                        p.getY()).getRgb().compareTo(shape.getRgbInt()) != 0) {
                queue.add(canvas.getPixel(p.getX() - 1, p.getY()));
                canvas.changePixel(p.getX() - 1, p.getY(), shape.getRgbInt(), shape.getIntA());
            }
            if (canvas.getPixel(p.getX() + 1, p.getY()) != null
                && canvas.getPixel(p.getX() + 1,
                        p.getY()).getRgb().compareTo(shape.getRgbExt()) != 0
                && canvas.getPixel(p.getX() + 1,
                        p.getY()).getRgb().compareTo(shape.getRgbInt()) != 0) {
                queue.add(canvas.getPixel(p.getX() + 1, p.getY()));
                canvas.changePixel(p.getX() + 1, p.getY(), shape.getRgbInt(), shape.getIntA());
            }
            if (canvas.getPixel(p.getX(), p.getY() - 1) != null
                && canvas.getPixel(p.getX(),
                        p.getY() - 1).getRgb().compareTo(shape.getRgbExt()) != 0
                && canvas.getPixel(p.getX(),
                        p.getY() - 1).getRgb().compareTo(shape.getRgbInt()) != 0) {
                queue.add(canvas.getPixel(p.getX(), p.getY() - 1));
                canvas.changePixel(p.getX(), p.getY() - 1, shape.getRgbInt(), shape.getIntA());
            }
            if (canvas.getPixel(p.getX(), p.getY() + 1) != null
                && canvas.getPixel(p.getX(),
                        p.getY() + 1).getRgb().compareTo(shape.getRgbExt()) != 0
                && canvas.getPixel(p.getX(),
                        p.getY() + 1).getRgb().compareTo(shape.getRgbInt()) != 0) {
                queue.add(canvas.getPixel(p.getX(), p.getY() + 1));
                canvas.changePixel(p.getX(), p.getY() + 1, shape.getRgbExt(), shape.getIntA());
            }
        }
    }

    /*
       Brutally filling Square and Rectangle shapes using two for loops because life is two fragile
       to live it on the edge.
       ("https://www.youtube.com/watch?v=z5Otla5157c")
    */
    public static void simpleFill(final Square shape, final Canvas canvas) {
        for (int i = shape.getStart().getY() + 1;
                i < shape.getStart().getY() + shape.getSide() - 1; i++) {
            for (int j = shape.getStart().getX() + 1;
                    j < shape.getStart().getX() + shape.getSide() - 1; j++) {
                if (i >= 0 && i < canvas.getHeight() && j >= 0 && j < canvas.getLength()) {
                    canvas.changePixel(j, i, shape.getRgbInt(), shape.getIntA());
                }
            }
        }
    }

    public static void simpleFill(final Rectangle shape, final Canvas canvas) {
        for (int i = shape.getStart().getY() + 1;
                i < shape.getStart().getY() + shape.getHeight() - 1; i++) {
            for (int j = shape.getStart().getX() + 1;
                    j < shape.getStart().getX() + shape.getLength() - 1; j++) {
                if (i >= 0 && i < canvas.getHeight() && j >= 0 && j < canvas.getLength()) {
                    canvas.changePixel(j, i, shape.getRgbInt(), shape.getIntA());
                }
            }
        }
    }

    public static void simpleFill(final Shape shape, final Canvas canvas) {
        //here's where lost socks go
    };
}
