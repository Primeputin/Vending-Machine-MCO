import javax.swing.*;

public class RefillView extends JFrame{
    private JButton a1Button;
    private JButton a5Button;
    private JButton a10Button;
    private JButton a100Button;
    private JButton a500Button1;
    private JButton a50Button;
    private JButton a20Button;
    private JTextField AmountTextField;
    private JButton OKButton;
    private JPanel RefillPanel;
    private JLabel AmountLabel;

    public RefillView()
    {
        setContentPane(RefillPanel);
        setTitle("Refill Change");
        setSize(300, 500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
    }
    public static void main (String args[])
    {
        RefillView RefillView  = new RefillView();
    }
}
