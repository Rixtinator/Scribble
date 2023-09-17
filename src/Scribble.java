import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Scribble extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

    Figure fig;
    List<Figure> figures = new ArrayList<>();
    String actionCommand = "Ovaal";
    Color color = Color.blue;
    JButton button;

    public Scribble() {
        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.blue);

        button = new JButton("Kleur aanpassen");
        button.addActionListener(this);
        button.setSize(40,40);
        this.add(button);
    }


    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3.0f));
        super.paint(g);
        for (Figure f : figures) {
            f.draw(g, f.color);
        }
    }

    public static void main(String[] args) {
        Scribble scribble = new Scribble();
        scribble.add(scribble.button, BorderLayout.SOUTH);

        //Menu
        JMenuBar menuBar = new JMenuBar();

        JMenu veranderVorm = new JMenu("Verander vorm");
        menuBar.add(veranderVorm);

        JMenuItem rechthoek = new JMenuItem("Rechthoek");
        rechthoek.addActionListener(scribble.menuItemActionListener);
        veranderVorm.add(rechthoek);
        JMenuItem ovaal = new JMenuItem("Ovaal");
        ovaal.addActionListener(scribble.menuItemActionListener);
        veranderVorm.add(ovaal);
        JMenuItem lijn = new JMenuItem("Lijn");
        lijn.addActionListener(scribble.menuItemActionListener);
        veranderVorm.add(lijn);
        JMenuItem driehoek = new JMenuItem("Driehoek");
        driehoek.addActionListener(scribble.menuItemActionListener);
        veranderVorm.add(driehoek);

        scribble.setJMenuBar(menuBar);
        menuBar.add(veranderVorm);

        //Frame Scribble
        scribble.setSize(400,400);
        scribble.setVisible(true);
        scribble.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

  ActionListener menuItemActionListener = e -> actionCommand = e.getActionCommand();

    @Override
    public void mousePressed(MouseEvent e) {
        switch (actionCommand) {
            case "Driehoek" -> fig = new Triangle(color);
            case "Rechthoek" -> fig = new Rect(color);
            case "Lijn" -> fig = new Line(color);
            case "Ovaal" -> fig = new Oval(color);
        }

        fig.x1 = e.getX();
        fig.y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        figures.add(fig);
        fig.setEnd(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            color = JColorChooser.showDialog(null, "kies een kleur", Color.black);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
