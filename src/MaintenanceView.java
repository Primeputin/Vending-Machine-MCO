import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.WindowAdapter;

public class MaintenanceView extends JFrame {
    private JButton btnGetMoney;
    private JButton btnPrintReport;
    private JButton btnRefillMoney;
    private JButton btnRestock;
    private JButton btnChangePrice;
    private JPanel MaintenacePanel;

    private int action;

    public MaintenanceView (){

        setContentPane(MaintenacePanel);
        setTitle("Maintenance");
        setSize(300,500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
    public void addPrintReportButtonListener (ActionListener listener)
    {
        btnPrintReport.addActionListener(listener);
    }
    public void addGetChangeListener (ActionListener listener)
    {
        btnGetMoney.addActionListener(listener);
    }
    public void addChangePriceListener(ActionListener listener)
    {
        btnChangePrice.addActionListener(listener);
    }
    public void addRestockListener (ActionListener listener)
    {
        btnRestock.addActionListener(listener);
    }
    public void addRefillListener(ActionListener listener)
    {
        btnRefillMoney.addActionListener(listener);
    }
    public void addMaintenanceExit(WindowAdapter windowAdapter)
    {
        this.addWindowListener(windowAdapter);
    }
}
