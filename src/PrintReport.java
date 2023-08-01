import javax.swing.*;
import java.awt.event.ComponentAdapter;

/**
 * This class is for displaying the print report panel
 */
public class PrintReport extends JFrame {
    /**
     * Panel for the whole print report panel
     */
    private JPanel ReportPanel;

    /**
     * This is the constructor method for the print report panel
     */
    public PrintReport() {
        setContentPane(ReportPanel);
        setTitle("Report");
        setSize(800, 500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    /**
     * creates a listener for when you exit the panel
     * @param componentAdapter It listens to what will happen to the component state
     */
    public void addPrintReportExit(ComponentAdapter componentAdapter) {
        this.addComponentListener(componentAdapter);
    }

    /**
     * Gets the printreport panel and returns it
     * @return the print report panel
     */
    public JPanel getPrintReport() {
        return this.ReportPanel;
    }
}
