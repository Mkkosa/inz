import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kosa_stacjonarny on 15.05.2017.
 */
public class OptionsBack extends JButton implements ActionListener {

    private OptionsWindow optionsWindow;

    public OptionsBack (OptionsWindow optionsWindow){
        this.optionsWindow=optionsWindow;
        setText("WRÓC");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        optionsWindow.close();
    }
}
