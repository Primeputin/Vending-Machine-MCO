import javax.swing.*;

public class GetChange extends JFrame {
    private JLabel Amount;
    private JPanel GetChangePanel;

    public GetChange()
    {
        setContentPane(GetChangePanel);
        setTitle("Change Gotten");
        setSize(300, 100);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Amount.setText("1");
        setVisible(true);
    }
    public static void main (String args[])
    {
        GetChange GetChange = new GetChange();
    }

}
