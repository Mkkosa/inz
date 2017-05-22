import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kosa_stacjonarny on 16.05.2017.
 */
public class OptionResultButton extends JButton implements ActionListener {

    private JFrame frame;
    private OptionsWindow optionsWindow;

    public OptionResultButton(JFrame frame, OptionsWindow optionsWindow){
        this.frame=frame;
        this.optionsWindow=optionsWindow;
        setText("OK");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        optionsWindow.close();
        frame.dispose();
    }
}
