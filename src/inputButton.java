import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class inputButton extends JButton {
    MainWindow mainWindow;

    public inputButton(MainWindow mainWindow) {
        super("Wjazd");

        this.mainWindow = mainWindow;

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectionButtonPressed();
            }
        });
    }

    public void selectionButtonPressed() {
        InWindow inWindow = new InWindow(mainWindow);
    }
}
