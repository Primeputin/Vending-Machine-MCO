import javax.swing.*;
import java.awt.event.ComponentAdapter;

public class PrintReport extends JFrame {
    private JPanel ReportPanel;

    public PrintReport() {
        setContentPane(ReportPanel);
        setTitle("Report");
        setSize(800, 500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    public void addPrintReportExit(ComponentAdapter componentAdapter) {
        this.addComponentListener(componentAdapter);
    }

    public JPanel getPrintReport() {
        return this.ReportPanel;
    }
}
