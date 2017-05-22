import javax.swing.*;
import java.awt.*;

/**
 * Created by Kosa_stacjonarny on 18.05.2017.
 */
public class ReportWindow extends JFrame {

    private MainWindow mainWindow;

    public ReportWindow (MainWindow mainWindow){
        this.mainWindow =mainWindow;
        setSize(400,400);
        setVisible(true);
        mainWindow.setEnabled(false);
        setResizable(false);
        setLayout(null);
        setLocation(mainWindow.getLocation().x+50,mainWindow.getLocation().y+50);
        getContentPane().setBackground(new Color(255, 105, 180));
        isAlwaysOnTop();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        createJLabel();
        createJTextField();

    }

    public void close(){
        mainWindow.setEnabled(true);
        this.dispose();
    }



    private void createJLabel () {
        JLabel report = new JLabel("RAPORT");
        JLabel chooseDay = new JLabel("WPISZ DZIEN");
        JLabel price = new JLabel("ZAROBEK");
        JLabel hourMax = new JLabel("GODZINA MAX");
        JLabel hourMin = new JLabel("GODZINA MIN");

        add(report);
        add(chooseDay);
        add(price);
        add(hourMax);
        add(hourMin);

        report.setBounds(180,0,200,40);
        chooseDay.setBounds(160,40,200,40);
        price.setBounds(20,140,100,40);
        hourMax.setBounds(150,140,100,40);
        hourMin.setBounds(280,140,100,40);


    }

    private void createJTextField (){
        JTextField day = new JTextField("yyyy-mm-dd");
        JTextField price = new JTextField();
        JTextField hourMax = new JTextField();
        JTextField hourMin = new JTextField();
        JTextField filename = new JTextField("filename");

        add(day);
        add(price);
        add(hourMax);
        add(hourMin);
        add(filename);

        day.setBounds(150,80,100,40);
        price.setBounds(10,180,80,40);
        hourMax.setBounds(135,180,130,40);
        hourMin.setBounds(260,180,130,40);
        filename.setBounds(50,250,140,40);

        ReportWindowBack reportWindowBack = new ReportWindowBack(this);
        add(reportWindowBack);
        reportWindowBack.setBounds(300,300,80,40);

        ReportWindowOk reportWindowOk = new ReportWindowOk(day,price,hourMax,hourMin);
        add(reportWindowOk);
        reportWindowOk.setBounds(260,80,80,40);



        ReportGenerate reportGenerate = new ReportGenerate(filename,day,price,hourMax,hourMin);
        add(reportGenerate);
        reportGenerate.setBounds(50,300,140,40);

    }

}
