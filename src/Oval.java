import java.awt.*;

public class Oval extends Figure {

    public Oval(Color color) {
        super(color);
    }

    public void draw(Graphics g, Color color) {
        g.setColor(color);
        g.drawOval(x1, y1, x2 - x1, y2 - y1);
    }
}
