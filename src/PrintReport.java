import javax.swing.*;

public class PrintReport extends JFrame{
    private JPanel ReportPanel;
    private JLabel ItemLabel;
    private JLabel StockBeforeLabel;
    private JLabel StockNowLabel;
    private JLabel soldLabel;
    private JLabel SaleLabel;
    private JLabel BunSumLabel;
    private JLabel ChickenFilletLabel;
    private JLabel MozarellaLabel;
    private JLabel OnionLabel;
    private JLabel FishFilletLabel;
    private JLabel LettuceSumLabel;
    private JLabel TomatoesSumLabel;
    private JLabel PattySumLabel;
    private JLabel ChickFilletSumLabel;
    private JLabel MozarellaSumLabel;
    private JLabel OnionSumLabel;
    private JLabel FishFilletSumLabel;
    private JLabel TotalSalesLabel;
    private JLabel AmountLabel;
    private JLabel BunLabel;
    private JLabel LettuceLabel;
    private JLabel TomatoesLabel;
    private JLabel PattyLabel;
    public PrintReport ()
    {
        setContentPane(ReportPanel);
        setTitle("Report");
        setSize(800, 500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
    }
    public static void main (String args[])
    {
        PrintReport PrintReport = new PrintReport();
    }
}
