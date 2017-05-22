import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kosa_stacjonarny on 18.05.2017.
 */
public class ReportButton extends JButton implements ActionListener {

    private MainWindow mainWindow;

    public ReportButton (MainWindow mainWindow){
        this.mainWindow=mainWindow;
        setText("Raport");
        addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ReportWindow reportWindow = new ReportWindow(mainWindow);
    }
}
