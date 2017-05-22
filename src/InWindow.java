import java.awt.*;

import javax.swing.*;

public class InWindow extends JFrame {
    MainWindow mainWindow;

    public InWindow(MainWindow mainWindow) {
        super("Wjazd");
        this.mainWindow = mainWindow;

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocation(mainWindow.getLocation().x + 50, mainWindow.getLocation().y + 50);
        setAlwaysOnTop(true);
        mainWindow.setEnabled(false);
        getContentPane().setBackground(new Color(153, 50, 204));

        setLayout(null);


        JEditorPane textArea = new JEditorPane();

        SubmitButtonInInputButton okButton = new SubmitButtonInInputButton(textArea, this);
        BackButtonInInputButton backButton = new BackButtonInInputButton(this);
        JLabel textLabel = new JLabel("Numer rejestracyjny: ");
        textLabel.setForeground(Color.white);


        textLabel.setBounds(100, 100, 200, 50);
        textArea.setBounds(100,150,200,30);


        okButton.setBounds(20,300,80,40);
        backButton.setBounds(300,300,80,40);


        add(backButton);
        add(textLabel);
        add(textArea);
        add(okButton);

        createStar();

        setVisible(true);



    }

    public void close (){
        mainWindow.setEnabled(true);
        this.dispose();
    }

    private void createStar (){
        JLabel first =new JLabel();
        first.setIcon(new ImageIcon(getClass().getResource("reasource/gwiazdaduza.png")));
        JLabel second =new JLabel();
        second.setIcon(new ImageIcon(getClass().getResource("reasource/gwiazdaduza.png")));

        JLabel third =new JLabel();
        third.setIcon(new ImageIcon(getClass().getResource("reasource/gwiazdasrednia.png")));
        JLabel fourth =new JLabel();
        fourth.setIcon(new ImageIcon(getClass().getResource("reasource/gwiazdasrednia.png")));
        JLabel fifth =new JLabel();
        fifth.setIcon(new ImageIcon(getClass().getResource("reasource/gwiazdasrednia.png")));

        JLabel sixth =new JLabel();
        sixth.setIcon(new ImageIcon(getClass().getResource("reasource/gwiazdamala.png")));
        JLabel seventh =new JLabel();
        seventh.setIcon(new ImageIcon(getClass().getResource("reasource/gwiazdamala.png")));
        JLabel eighth =new JLabel();
        eighth.setIcon(new ImageIcon(getClass().getResource("reasource/gwiazdamala.png")));

        first.setBounds(40,260,40,40);
        third.setBounds(30,190,20,20);
        sixth.setBounds(40,100,10,10);
        fourth.setBounds(60,50,20,20);

        second.setBounds(300,50,40,40);
        seventh.setBounds(340,120,10,10);
        eighth.setBounds(320,180,10,10);
        fifth.setBounds(280,250,20,20);

        add(first);
        add(third);
        add(sixth);
        add(fourth);
        add(second);
        add(seventh);
        add(eighth);
        add(fifth);
    }


}
