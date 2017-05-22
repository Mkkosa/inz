import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MainLabel extends JLabel {
    public MainLabel(int nEmptySlots){
        super(" Liczba wolnych miejsc:  " + nEmptySlots + " ");
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
