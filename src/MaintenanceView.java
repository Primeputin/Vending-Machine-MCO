import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.WindowAdapter;

/**
 * This is the class for displaying the maintenance view
 */
public class MaintenanceView extends JFrame {
    private JButton btnGetMoney;
    private JButton btnPrintReport;
    private JButton btnRefillMoney;
    private JButton btnRestock;
    private JButton btnChangePrice;
    private JPanel MaintenacePanel;

    private int action;

    /**
     * Is the constructor method for the maintenance view
     */
    public MaintenanceView (){

        setContentPane(MaintenacePanel);
        setTitle("Maintenance");
        setSize(300,500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    /**
     * Adds a listener for when you click the Print report button
     * @param listener is the one that listens for something to happen. Afterward, it does a certain action when you press a button
     */
    public void addPrintReportButtonListener (ActionListener listener)
    {
        btnPrintReport.addActionListener(listener);
    }
    /**
     * Adds a listener for when you click the Get change button
     * @param listener is the one that listens for something to happen. Afterward, it does a certain action when you press a button
     */
    public void addGetChangeListener (ActionListener listener)
    {
        btnGetMoney.addActionListener(listener);
    }
    /**
     * Adds a listener for when you click the Change Price button
     * @param listener is the one that listens for something to happen. Afterward, it does a certain action when you press a button
     */
    public void addChangePriceListener(ActionListener listener)
    {
        btnChangePrice.addActionListener(listener);
    }
    /**
     * Adds a listener for when you click the Restock button
     * @param listener is the one that listens for something to happen. Afterward, it does a certain action when you press a button
     */
    public void addRestockListener (ActionListener listener)
    {
        btnRestock.addActionListener(listener);
    }
    /**
     * Adds a listener for when you click the Refill button
     * @param listener is the one that listens for something to happen. Afterward, it does a certain action when you press a button
     */
    public void addRefillListener(ActionListener listener)
    {
        btnRefillMoney.addActionListener(listener);
    }
    /**
     * creates a listener for when you exit the panel
     * @param windowAdapter is the one that listens for something to happen. Afterward, it does a certain action when you exit
     */
    public void addMaintenanceExit(WindowAdapter windowAdapter)
    {
        this.addWindowListener(windowAdapter);
    }
}
