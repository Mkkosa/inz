import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kosa on 17.05.2017.
 */
public class TakePlaceButton extends JButton implements ActionListener {

    private JFrame frame;
    private InWindow window;

    public TakePlaceButton (JFrame frame, InWindow window){
        this.frame=frame;
        this.window=window;
        setText("OK");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.setEnabled(true);
        frame.dispose();
    }
}
