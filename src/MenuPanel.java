import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {

    public MenuPanel(MainWindow mainWindow) {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setPreferredSize(new Dimension(470, 35));

        OptionButton optionsButton = new OptionButton(mainWindow);
        inputButton inButton = new inputButton(mainWindow);
        JButton outButton = new JButton("Wyjazd");
        ReportButton raportButton = new ReportButton(mainWindow);
        MainLabel emptySlots = new MainLabel(Database.countEmptyPlace());

        add(Box.createRigidArea(new Dimension(2, 0)));
        add(optionsButton);
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(emptySlots);
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(raportButton);
        add(Box.createRigidArea(
                new Dimension((int) (getPreferredSize().getWidth() - ((optionsButton.getPreferredSize().getWidth()
                        + inButton.getPreferredSize().getWidth() + outButton.getPreferredSize().getWidth()
                        + raportButton.getPreferredSize().getWidth() + emptySlots.getPreferredSize().getWidth()))),
                        0)));
        add(inButton);
        add(outButton);

        setVisible(true);
    }

}
