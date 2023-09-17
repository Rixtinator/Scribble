import java.awt.*;

public abstract class Figure {
    int x1, y1, x2, y2;
    public Color color;

    public Figure(Color color) {
        this.color = color;
    }

    public void setEnd (int x, int y) {
        x2 = x;
        y2 = y;

        if (x2 < x1) {
            int tmp = x2;
            x2 = x1;
            x1 = tmp;
        }

        if (y2 < y1) {
            int tmp2 = y2;
            y2 = y1;
            y1 = tmp2;
        }
    }

    public abstract void draw(Graphics g, Color color);

}
