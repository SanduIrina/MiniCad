package classes;
import java.io.IOException;

/*
    Visitor pattern in being used. Visit method is "double overloaded" in a sense that is once
    overloaded for every shape and then for two types of opperations( opposed to having
    two visitors):

    1. Initializing shapes: shapes have different input data so once the type is read, visitor
    receives the shape and the reading file and reads data accordingly for every type of shape
    based on the number of parameters required.

    2. Drawing shape borders: in the second part, each shape is being drawed using the specific
    type of drawing algorythm with respect to their type. For this, the method receives both the
    shape and the canvas as parameters.

    The trade-off for this was initializing members through setters rather than through a
    constructor. Forgive me father, for I have sinned.
*/

public class InitVisitor implements Visitor {
    private FileSystem f;
    public InitVisitor(final FileSystem f) {
        this.f = f;
    }


    /*
     * setting start and stop points and color specifics for all shapes
     */

    @Override
    public void visit(final Line line) {
        int x1, x2, y1, y2, a;
        String rgb;
        try {
            x1 = f.nextInt();
            y1 = f.nextInt();
            x2 = f.nextInt();
            y2 = f.nextInt();
            rgb = f.nextWord();
            a = f.nextInt();
            line.setStart(x1, y1, rgb, a);
            line.setStop(x2, y2, rgb, a);
            line.setRgbExt(rgb);
            line.setExtA(a);
        } catch (IOException e) {
        }
    }

    /* (non-Javadoc)
     * @see Visitor#visit(Circle)
     */
    @Override
    public void visit(final Circle circle) {
        int x, y, aInt, aExt, radius;
        String rgbInt, rgbExt;
        try {
            x = f.nextInt();
            y = f.nextInt();
            radius = f.nextInt();
            rgbExt = f.nextWord();
            aExt = f.nextInt();
            rgbInt = f.nextWord();
            aInt = f.nextInt();
            circle.setStart(x, y, rgbInt, aInt);
            circle.setRadius(radius);
            circle.setExtA(aExt);
            circle.setIntA(aInt);
            circle.setRgbExt(rgbExt);
            circle.setRgbInt(rgbInt);
            circle.setgCenter(x, y, rgbInt, aInt);
        } catch (IOException e) {
        }
    }

    /* (non-Javadoc)
     * @see Visitor#visit(Triangle)
     */
    @Override
    public void visit(final Triangle triangle) {
        int x1, x2, x3, y1, y2, y3, aExt, aInt;
        String rgbExt, rgbInt;
        try {
            x1 = f.nextInt();
            y1 = f.nextInt();
            x2 = f.nextInt();
            y2 = f.nextInt();
            x3 = f.nextInt();
            y3 = f.nextInt();
            rgbExt = f.nextWord();
            aExt = f.nextInt();
            rgbInt = f.nextWord();
            aInt = f.nextInt();
            triangle.setStart(x1, y1, rgbExt, aExt);
            triangle.setMid(x2, y2, rgbExt, aExt);
            triangle.setStop(x3, y3, rgbExt, aExt);
            triangle.setExtA(aExt);
            triangle.setIntA(aInt);
            triangle.setRgbInt(rgbInt);
            triangle.setRgbExt(rgbExt);
            triangle.setgCenter((int) ((x1 + x2 + x3) / Magic.THREE),
                    (int) ((y1 + y2 + y3) / Magic.THREE), rgbInt, aInt);
        } catch (IOException e) {
        }
    }

    /* (non-Javadoc)
     * @see Visitor#visit(Square)
     */
    @Override
    public void visit(final Square square) {
        int x, y, side, aInt, aExt;
        String rgbExt, rgbInt;
        try {
            x = f.nextInt();
            y = f.nextInt();
            side = f.nextInt();
            rgbExt = f.nextWord();
            aExt = f.nextInt();
            rgbInt = f.nextWord();
            aInt = f.nextInt();
            square.setStart(x, y, rgbExt, aExt);
            square.setExtA(aExt);
            square.setIntA(aInt);
            square.setRgbExt(rgbExt);
            square.setRgbInt(rgbInt);
            square.setSide(side);
        } catch (IOException e) {
        }
    }

    /* (non-Javadoc)
     * @see Visitor#visit(Polygon)
     */
    @Override
    public void visit(final Polygon polygon) {
        int n, x, y, aExt, aInt, i, xAux = 0, yAux = 0;
        String rgbExt, rgbInt;
        try {
            n = f.nextInt();
            polygon.setN(n);
            for (i = 0; i < n; i++) {
                x = f.nextInt();
                y = f.nextInt();
                polygon.setIpoints(i, x, y);
                xAux += x;
                yAux += y;
            }
            rgbExt = f.nextWord();
            aExt = f.nextInt();
            rgbInt = f.nextWord();
            aInt = f.nextInt();
            for (i = 0; i < n; i++) {
                polygon.setColor(rgbInt, aExt);
            }
            polygon.setExtA(aExt);
            polygon.setIntA(aInt);
            polygon.setRgbExt(rgbExt);
            polygon.setRgbInt(rgbInt);
            x = (int) Math.floor(xAux / n);
            y = (int) Math.floor(yAux / n);
            polygon.setgCenter(x, y, polygon.getRgbInt(), polygon.getIntA());
        } catch (IOException e) {
        }
    }

    /* (non-Javadoc)
     * @see Visitor#visit(Rectangle)
     */
    @Override
    public void visit(final Rectangle rectangle) {
        int x, y, length, height, aExt, aInt;
        String rgbExt, rgbInt;
        try {
            x = f.nextInt();
            y = f.nextInt();
            height = f.nextInt();
            System.out.println(height);
            length = f.nextInt();
            System.out.println(length);
            rgbExt = f.nextWord();
            aExt = f.nextInt();
            rgbInt = f.nextWord();
            aInt = f.nextInt();
            rectangle.setStart(x, y, rgbExt, aExt);
            rectangle.setExtA(aExt);
            rectangle.setHeight(height);
            rectangle.setLength(length);
            rectangle.setIntA(aInt);
            rectangle.setRgbExt(rgbExt);
            rectangle.setRgbInt(rgbInt);
        } catch (IOException e) {
        }
    }

    /* (non-Javadoc)
     * @see Visitor#visit(Diamond)
     */
    @Override
    public void visit(final Diamond diamond) {
        int x, y, hDiag, vDiag, aExt, aInt;
        String rgbExt, rgbInt;
        try {
            x = f.nextInt();
            y = f.nextInt();
            hDiag = f.nextInt();
            vDiag = f.nextInt();
            rgbExt = f.nextWord();
            aExt = f.nextInt();
            rgbInt = f.nextWord();
            aInt = f.nextInt();
            diamond.setStart(x, y, rgbExt, aExt);
            diamond.setExtA(aExt);
            diamond.sethDiag(hDiag);
            diamond.setIntA(aInt);
            diamond.setRgbExt(rgbExt);
            diamond.setRgbInt(rgbInt);
            diamond.setvDiag(vDiag);
            diamond.setgCenter(x, y, rgbInt, aInt);
        } catch (IOException e) {
        }
    }
    /* (non-Javadoc)
     * @see Visitor#visit(Shape)
     */
    @Override
    public void visit(final Shape shape) {
        System.out.println("something went wrong :(");
    }

    /*
     Drawing borders methods start here. In each method I( and everybody else who did this
     homework) used Bresenhams algorythm for drawing both polygon-typed and circle shapes.
     (Note: using this line-drawing algorythm, a line from point A to B is different from one
     from B to A by a couple of pixels due to incremental errors. Good luck to anyone not knowing
     this and trying to find that one or two pixels that are displaced by one unit.)
     */
    @Override
    public void visit(final Line line, final Canvas canvas) {
        Bresenhams.draw(line.getStart(), line.getStop(), line.getExtA(), line.getRgbExt(), canvas);
    }

    /*
     */
    @Override
    public void visit(final Circle circle, final Canvas canvas) {
        Bresenhams.circleBres(circle, canvas);
    }

    /*
     */
    @Override
    public void visit(final Triangle triangle, final Canvas canvas) {
        Bresenhams.draw(triangle.getStart(), triangle.getMid(),
                triangle.getExtA(), triangle.getRgbExt(), canvas);
        Bresenhams.draw(triangle.getMid(), triangle.getStop(),
                triangle.getExtA(), triangle.getRgbExt(), canvas);
        Bresenhams.draw(triangle.getStop(), triangle.getStart(),
                triangle.getExtA(), triangle.getRgbExt(), canvas);
    }

    /*
     */
    @Override
    public void visit(final Square square, final Canvas canvas) {
        Point p1, p3;
        p1 = new Point(square.getStart().getX() + square.getSide() - 1,
                square.getStart().getY(), square.getRgbExt(), square.getExtA());
        p3 = new Point(square.getStart().getX(), square.getStart().getY() + square.getSide() - 1,
                square.getRgbExt(), square.getExtA());

        for (int x = square.getStart().getX(); x <= p1.getX(); x++) {
            canvas.changePixel(x, p1.getY(), square.getRgbExt(), square.getExtA());
            canvas.changePixel(x, p3.getY(), square.getRgbExt(), square.getExtA());
        }
        for (int y = square.getStart().getY(); y <= p3.getY(); y++) {
            canvas.changePixel(p3.getX(), y, square.getRgbExt(), square.getExtA());
            canvas.changePixel(p1.getX(), y, square.getRgbExt(), square.getExtA());
        }

    }

    /*
     */
    @Override
    public void visit(final Polygon polygon, final Canvas canvas) {
        int n = polygon.getN();
        int i;
        for (i = 1; i < n; i++) {
            Bresenhams.draw(polygon.getIpoints(i - 1), polygon.getIpoints(i), polygon.getExtA(),
                    polygon.getRgbExt(), canvas);
        }
        Bresenhams.draw(polygon.getIpoints(n  - 1), polygon.getIpoints(0), polygon.getExtA(),
                polygon.getRgbExt(), canvas);
    }

    /*
     */
    @Override
    public void visit(final Rectangle rectangle, final Canvas canvas) {
        Point p1, p2, p3;
        p1 = new Point(rectangle.getStart().getX() + rectangle.getLength() - 1,
                       rectangle.getStart().getY(), rectangle.getRgbExt(), rectangle.getExtA());
        p2 = new Point(p1.getX(), p1.getY() + rectangle.getHeight() - 1,
                       rectangle.getRgbExt(), rectangle.getExtA());
        p3 = new Point(rectangle.getStart().getX(),
                       rectangle.getStart().getY() + rectangle.getHeight() - 1,
                       rectangle.getRgbExt(), rectangle.getExtA());

        for (int x = rectangle.getStart().getX(); x <= p1.getX(); x++) {
            canvas.changePixel(x, p1.getY(), rectangle.getRgbExt(), rectangle.getExtA());
            canvas.changePixel(x, p2.getY(), rectangle.getRgbExt(), rectangle.getExtA());
        }

        for (int y = rectangle.getStart().getY(); y <= p3.getY(); y++) {
            canvas.changePixel(p3.getX(), y, rectangle.getRgbExt(), rectangle.getExtA());
            canvas.changePixel(p1.getX(), y, rectangle.getRgbExt(), rectangle.getExtA());
        }
    }

    /*
     */
    @Override
    public void visit(final Diamond diamond, final Canvas canvas) {
        Point p1, p2, p3, p4;
        p1 = new Point(diamond.getStart().getX() + (diamond.gethDiag() / 2),
                diamond.getStart().getY(), diamond.getRgbExt(), diamond.getStart().getA());
        p2 = new Point(diamond.getStart().getX(),
                diamond.getStart().getY() - (diamond.getvDiag() / 2),
                diamond.getRgbExt(), diamond.getStart().getA());
        p3 = new Point(diamond.getStart().getX() - (diamond.gethDiag() / 2),
                diamond.getStart().getY(), diamond.getRgbExt(), diamond.getStart().getA());
        p4 = new Point(diamond.getStart().getX(),
                diamond.getStart().getY() + (diamond.getvDiag() / 2), diamond.getRgbExt(),
                diamond.getStart().getA());
        Bresenhams.draw(p1, p2, diamond.getExtA(), diamond.getRgbExt(), canvas);
        Bresenhams.draw(p2, p3, diamond.getExtA(), diamond.getRgbExt(), canvas);
        Bresenhams.draw(p3, p4, diamond.getExtA(), diamond.getRgbExt(), canvas);
        Bresenhams.draw(p4, p1, diamond.getExtA(), diamond.getRgbExt(), canvas);
    }

    @Override
    public void visit(final Shape shape, final Canvas canvas) {
    }
}
