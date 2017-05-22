import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.white;
import static java.awt.Color.yellow;

/**
 * Created by Kosa_stacjonarny on 15.05.2017.
 */
public class OptionsWindow extends JFrame {
    private MainWindow mainWindow;

    public OptionsWindow (MainWindow mainWindow){
        super("Opcje");
        this.mainWindow=mainWindow;
        mainWindow.setEnabled(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(400,400);
        setLocation(mainWindow.getLocation().x+50, mainWindow.getLocation().y+50);
        setLayout(null);
        getContentPane().setBackground(Color.blue);




        OptionsBack back = new OptionsBack(this);
        JLabel max = new JLabel("Maksymalna ilość miejsc: ");
        max.setForeground(white);
        JLabel edit = new JLabel("Edycja cennika");
        edit.setForeground(white);
        JLabel day = new JLabel("Taryfa dzienna 6-22");
        day.setForeground(white);
        JLabel night = new JLabel("Taryfa nocna 22-6");
        night.setForeground(white);
        JEditorPane maxText = new JEditorPane();
        maxText.setText(String.valueOf(Database.getDataDane(2)));
        JEditorPane dayText = new JEditorPane();
        dayText.setText(String.valueOf(Database.getDataDane(3)));
        JEditorPane nightText = new JEditorPane();
        nightText.setText(String.valueOf(Database.getDataDane(4)));
        OptionsSubmitButton submit = new OptionsSubmitButton(maxText, dayText, nightText, this);

        JLabel heartBig1 = new JLabel();
        heartBig1.setBounds(15,50,40,40);
        heartBig1.setIcon(new ImageIcon(getClass().getResource("reasource/serduszkoduze.png")));

        JLabel heartBig2 = new JLabel();
        heartBig2.setBounds(320,150,40,40);
        heartBig2.setIcon(new ImageIcon(getClass().getResource("reasource/serduszkoduze.png")));

        JLabel heartSmall1 = new JLabel();
        heartSmall1.setBounds(270,80,20,20);
        heartSmall1.setIcon(new ImageIcon(getClass().getResource("reasource/serduszkomale.png")));

        JLabel heartSmall2 = new JLabel();
        heartSmall2.setBounds(200,300,20,20);
        heartSmall2.setIcon(new ImageIcon(getClass().getResource("reasource/serduszkomale.png")));


        max.setBounds(20,15,200,40);
        maxText.setBounds(220,15,40,40);

        edit.setBounds(20,80,200,40);

        day.setBounds(20,140,200,40);
        dayText.setBounds(220,140,40,40);

        night.setBounds(20,200,200,40);
        nightText.setBounds(220,200,40,40);

        submit.setBounds(5,300,80,40);

        back.setBounds(300,300,80,40);

        add(submit);
        add(back);
        add(max);
        add(edit);
        add(day);
        add(night);
        add(maxText);
        add(dayText);
        add(nightText);

        add(heartBig1);
        add(heartBig2);
        add(heartSmall1);
        add(heartSmall2);

        setVisible(true);
    }

    public void close (){
        mainWindow.setEnabled(true);
        this.dispose();
    }


}