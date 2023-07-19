import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setVisible(true);

    }
    public static void main (String args[])
    {
        MaintenanceView MaintenanceView = new MaintenanceView();
    }

}
