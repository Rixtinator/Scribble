import java.awt.*;

public class Triangle extends Figure {

    public Triangle (Color color) {
        super(color);
    }

    public void draw (Graphics g, Color color) {
        g.setColor(color);
        g.drawLine (x1, y2, x2, y2);
        g.drawLine (x1, y2, (x2/2)+(x1/2), y1);
        g.drawLine ((x2/2)+(x1/2), y1, x2, y2);
    }
}
