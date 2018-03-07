
import java.io.File;

import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import classes.*;

public final class Main {
    private Main() { };
    public static void main(final String[] args) {
        int i, n, length, height, a;
        String type, rgb;
        ShapeFactory factory = ShapeFactory.getShapeFactory();
        Shape shape;
        try {
            FileSystem f = new FileSystem(args[0], " ");
            //Reading stats for canvas separately
            n = f.nextInt();
            System.out.println(n);
            type = f.nextWord();
            System.out.println(type);
            height = f.nextInt();
            System.out.println(height);
            length = f.nextInt();
            System.out.println(length);
            rgb = f.nextWord();
            System.out.println(rgb);
            a = f.nextInt();
            System.out.println(a);
            Canvas canvas = Canvas.getCanvas();
            //Singleton pattern is being used in Canvas so the fiels are being set through setters
            canvas.setHeight(height);
            canvas.setLength(length);
            canvas.setRgb(rgb);
            canvas.setMat();
            InitVisitor init = new InitVisitor(f);
            for (i = 1; i < n; i++) {
                type = f.nextWord();
                shape = factory.getShape(type);
                shape.accept(init, canvas);
            //Brutally checking types for fill method
                if (type.equals("SQUARE")) {
                    Bresenhams.simpleFill((Square) shape, canvas);
                } else
                    if (type.equals("RECTANGLE")) {
                        Bresenhams.simpleFill((Rectangle) shape, canvas);
                    } else
                        if (type.equals("CIRCLE") || type.equals("DIAMOND")
                                || type.equals("POLYGON") || type.equals("TRIANGLE")) {
                        Bresenhams.floodFill(shape, canvas);
                        }
            }
            f.close();
            BufferedImage img = new BufferedImage(length, height, BufferedImage.TYPE_4BYTE_ABGR);
            //Drawing the image using BufferedImage and Color
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < length; x++) {
                        Color aux = Color.decode(canvas.getRgbPixel(x, y));
                        Color col = new Color(aux.getRed(), aux.getGreen(), aux.getBlue(), a);
                        img.setRGB(x, y, col.getRGB());
                }
            }
            File out = new File("drawing.png");
            ImageIO.write(img, "png", out);

        } catch (IOException e) {

        }
    }
}
