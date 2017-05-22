
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

    public MainWindow() {
        super("Parking");

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (d.getWidth() - 500) / 2;
        int y = (int) (d.getHeight() - 500) / 2;

        setSize(500, 500);
        setLocation(new Point(x, y));
        setResizable(false);

        Database database = new Database();

        setLayout(new BorderLayout());

        MenuPanel menuPanel = new MenuPanel(this);
        add(menuPanel, BorderLayout.NORTH);

        TablePanel tablePanel = new TablePanel(new MainTable(database.getDate()));
        add(tablePanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }

    public Point getPosition() {
        return getLocation();
    }
}
