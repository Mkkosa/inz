import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kosa_stacjonarny on 16.05.2017.
 */
public class BackButtonInInputButton extends JButton implements ActionListener {

    private InWindow inWindow;

    public BackButtonInInputButton (InWindow inWindow){
        this.inWindow = inWindow;
        setText("WRÓC");
        addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        inWindow.close();
    }
}
