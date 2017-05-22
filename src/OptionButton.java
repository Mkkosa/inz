import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Kosa_stacjonarny on 15.05.2017.
 */
public class OptionButton extends JButton implements ActionListener {

    private MainWindow mainWindow;

    public OptionButton (MainWindow mainWindow){
        this.mainWindow = mainWindow;
        this.setText("Opcje");
        addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        OptionsWindow optionsWindow = new OptionsWindow(mainWindow);
    }
}
