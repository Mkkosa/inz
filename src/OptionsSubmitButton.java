import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kosa_stacjonarny on 15.05.2017.
 */
public class OptionsSubmitButton extends JButton implements ActionListener {

    private JEditorPane maxText, dayText, nightText;
    private Pattern pattern;
    private Matcher matcher;
    private OptionsWindow optionsWindow;

    public OptionsSubmitButton (JEditorPane maxText, JEditorPane dayText, JEditorPane nightText, OptionsWindow optionsWindow){
        this.dayText=dayText;
        this.optionsWindow=optionsWindow;
        this.maxText = maxText;
        this.nightText=nightText;
        setText("OK");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tempDay, tempNight, tempMax;

        tempDay = dayText.getText();
        pattern = Pattern.compile("[0-9]+[.]?[0-9]*");
        matcher = pattern.matcher(tempDay);
        if (matcher.matches()){
            tempDay = "1";
        } else {
            tempDay = "0";
        }

        tempNight = nightText.getText();
        pattern = Pattern.compile("[0-9]+[.]?[0-9]*");
        matcher = pattern.matcher(tempNight);
        if (matcher.matches()){
            tempNight = "1";
        } else {
            tempNight = "0";
        }

        tempMax = maxText.getText();
        pattern = Pattern.compile("[1-9]+[0-9]*");
        matcher = pattern.matcher(tempMax);
        if (matcher.matches()){
            tempMax = "1";
        } else {
            tempMax = "0";
        }

        optionsWindow.setEnabled(false);
        JFrame frame = new JFrame("Podsumowanie");
        frame.setSize(200,200);
        frame.setLocation(optionsWindow.getLocation().x+50, optionsWindow.getLocation().y+50);
        frame.setLayout(new BorderLayout());
        JLabel discription = new JLabel();
        OptionResultButton submitButton = new OptionResultButton(frame, optionsWindow);

        if (tempDay == "0" && tempMax == "0" && tempNight == "0"){
           discription.setText("Błędne dane!");
        } else {

            if (tempNight == "1") Database.setDataDane(4, nightText.getText());
            if (tempDay == "1" ) Database.setDataDane(3, dayText.getText());
            if (tempMax == "1") {

                if(Integer.parseInt(Database.getDataDane(2))<Integer.parseInt(maxText.getText())){

                    int temp = Integer.parseInt(maxText.getText()) - Integer.parseInt(Database.getDataDane(2));
                    Database.insertPlace(temp);
                    Database.setDataDane(2, maxText.getText());
                    discription.setText("Dane zmieniono!");

                } else if (Integer.parseInt(Database.getDataDane(2))>Integer.parseInt(maxText.getText())){

                    int temp = Integer.parseInt(Database.getDataDane(2)) -  Integer.parseInt(maxText.getText());

                    if (temp < 0 || temp > Database.countEmptyPlace()) {
                        discription.setText("Miejsca zajete! Nie mozna usunac!");
                    } else {
                        Database.deletePlace(temp);
                        //Database.setDataDane(2, maxText.getText());
                        discription.setText("Dane zmieniono!");
                    }

                } else {
                    Database.setDataDane(2, maxText.getText());
                    discription.setText("      Zmieniono dane!");
                }
            } else {
                discription.setText("Bledne dane");
            }
        }

        frame.add(submitButton, BorderLayout.SOUTH);
        frame.add(discription, BorderLayout.CENTER);
        frame.setVisible(true);



    }
}
