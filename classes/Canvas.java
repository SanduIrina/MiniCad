package classes;
public final class Canvas {
    private int height, length, a;
    private String rgb;
    private Point[][] canvas;
    private static Canvas instance = null;

    private Canvas() { }

    //Singleton pattern is used

    public static Canvas getCanvas() {
        if (instance == null) {
            instance = new Canvas();
        }
        return instance;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public void setMat() {
        canvas = new Point[height][length];
        int x, y;
        for (y = 0; y < height; y++) {
            for (x = 0; x < length; x++) {
                canvas[y][x] = new Point(x, y, rgb, a);
            }
        }
    }

    public void changePixel(final int x, final int y, final String brg, final int aNew) {
        if (x >= 0 && x < this.length && y >= 0 && y < this.height) {
            canvas[y][x].setA(aNew);
            canvas[y][x].setRgb(brg);
        }
    }

    public Point getPixel(final int x, final int y) {
        if (x >= 0 && x < this.length && y >= 0 && y < this.height) {
            return canvas[y][x];
        }
        return null;
    }

    public int getLength() {
        return length;
    }

    public void setLength(final int length) {
        this.length = length;
    }

    public String getRgb() {
        return rgb;
    }

    public String getRgbPixel(final int x, final int y) {
        return canvas[y][x].getRgb();
    }

    public void setRgb(final String rgb) {
        this.rgb = rgb;
    }

    public int getA() {
        return a;
    }

    public void setA(final int a) {
        this.a = a;
    }

    public int getAPixel(final int x, final int y) {
        return canvas[y][x].getA();
    }
}
