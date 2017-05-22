import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kosa_stacjonarny on 18.05.2017.
 */
public class ReportWindowBack extends JButton implements ActionListener {

    ReportWindow reportWindow ;

    public ReportWindowBack (ReportWindow reportWindow){
        this.reportWindow =reportWindow;
        setText("WROC");
        addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        reportWindow.close();
    }
}
