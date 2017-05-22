import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Kosa_stacjonarny on 18.05.2017.
 */
public class ReportGenerate extends JButton implements ActionListener {

    JTextField filename, day,price,hourMax,hourMin;

    public ReportGenerate (JTextField filename, JTextField day, JTextField price, JTextField hourMax, JTextField hourMin) {
        this.filename=filename;
        this.day=day;
        this.price=price;
        this.hourMax=hourMax;
        this.hourMin=hourMin;
        setText("Generuj plik .txt");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (price.getText().length()==0){
            filename.setText("Najpierw wcisni OK");
        } else{

        File plik = new File(filename.getText() +".txt");
        try {
            PrintWriter write = new PrintWriter(filename.getText() + ".txt");
            write.println("!!!---RAPORT PARKING---!!!");
            write.println("!!!--Dzien: " + day.getText() + "--!!");
            write.println("!!!--Zarobek: " + price.getText() + "--!!!");
            write.println("!!!--Najwiecej samochodow w godzinach: " + hourMax.getText() + "--!!!");
            write.println("!!!--Najminiej samochodow w godzinach: " + hourMin.getText() + "--!!!");


            write.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }}
}
