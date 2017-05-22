import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Kosa_stacjonarny on 18.05.2017.
 */
public class ReportWindowOk extends JButton implements ActionListener {

    JTextField day, price, hourMax, hourMin;

    public ReportWindowOk (JTextField day, JTextField price, JTextField hourMax, JTextField hourMin){
        this.day=day;
        this.price=price;
        this.hourMax=hourMax;
        this.hourMin=hourMin;
        setText("OK");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String[] data;
        String date = day.getText();

        data = Database.getPriceAndTime(date);
        price.setText(data[0]);
        hourMax.setText(data[1]);
        hourMin.setText(data[2]);

    }
}
