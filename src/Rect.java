import java.awt.*;

public class Rect extends Figure {

    public Rect(Color color) {
        super(color);
    }

    public void draw (Graphics g, Color color) {
        g.setColor(color);
        g.drawRect(x1, y1, x2 - x1, y2 - y1 );
    }
}
