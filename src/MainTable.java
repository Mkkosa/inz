import javax.swing.JTable;

@SuppressWarnings("serial")
public class MainTable extends JTable {
    static String[] columnNames = { "ID miejca", "Numer rejestracyjny", "Data start", "Czas postoju"};

    public MainTable(Object[][] date) {
        super(date, columnNames);
        //	setAutoCreateRowSorter(true);



        setDefaultEditor(Object.class, null);
        setCellSelectionEnabled(false);
    }

    public Object[][] getData(){

        return null;
    }
}
