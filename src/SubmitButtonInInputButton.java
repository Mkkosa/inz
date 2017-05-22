import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import sun.awt.WindowClosingListener;

public class SubmitButtonInInputButton extends JButton implements ActionListener {

    private JButton button;
    private JEditorPane textArea;
    private String carId;
    private Pattern pattern;
    private Matcher matcher;
    private InWindow window;

    public SubmitButtonInInputButton (JEditorPane textArea, InWindow window){
        this.textArea = textArea;
        this.window = window;
        setText("OK");
        addActionListener(this);


    }

    public void actionPerformed(ActionEvent arg0) {
        carId = textArea.getText();
        pattern = Pattern.compile("[a-zA-Z0-9]+[a-zA-Z0-9 ]*");
        matcher = pattern.matcher(carId);
        if (matcher.matches()){
            if (carId.length()>8 || carId.length()==0){
                textArea.setText("Podaj poprawne dane");
            } else {
                JFrame frame = new JFrame();
                frame.setSize(200,200);
                frame.setLocation(window.getLocation().x+50, window.getLocation().y+50);
                window.setEnabled(false);
                frame.setLayout(null);
                frame.setAlwaysOnTop(true);
                frame.getContentPane().setBackground(new Color(153, 50, 204));
                frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

                TakePlaceButton subbmit = new TakePlaceButton(frame, window);
                subbmit.setBounds(0,130,190,30);
                frame.add(subbmit);

                JLabel text = new JLabel("PRZYDZIELONE MIEJSCE");
                text.setBounds(20,30,150,40);
                frame.add(text);

                JLabel textField = new JLabel();
                textField.setText(Database.getData(carId));
                textField.setBounds(80,80,50,40);
                frame.add(textField);



                frame.setResizable(false);

                frame.setVisible(true);


                window.close();
            }
        } else {
            textArea.setText("Podaj poprawne dane");
        }

    }

}
