import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class TablePanel extends JScrollPane {
    public TablePanel(MainTable mainTable) {
        super(mainTable);

        mainTable.setFillsViewportHeight(true);
    }
}
