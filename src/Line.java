import java.awt.*;

public class Line extends Figure {

    public Line(Color color) {
        super(color);
    }

    public void draw (Graphics g, Color color) {
        g.setColor(color);
        g.drawLine (x1, y1, x2, y2);
    }

    @Override
    public void setEnd(int x, int y) {
        x2 = x;
        y2 = y;
    }
}
