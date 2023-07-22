import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
public class MaintenanceController {
    private VendingModel vendingModel;
    private ChangePriceView changePriceView;
    private GetChange getChange;
    private PrintReport printReport;
    private RefillView refillView;
    private RestockView restockView;
    private MaintenanceView maintenanceView;

    public MaintenanceController() {
        this.changePriceView = new ChangePriceView();
        this.getChange = new GetChange();
        this.maintenanceView = new MaintenanceView();
        this.printReport = new PrintReport();
        this.refillView = new RefillView();
        this.restockView = new RestockView();

        addPrintReportListener();
        addGetChangeListener();
        addChangePriceListener();
        addRestockListener();
        addRefillListener();
        addGetChangeExit();
        addPrintReportExit();
        addChangePriceExit();
        addRestockExit();
        addRefillExit();
        addRefillButtons();
        addRestockButton();
        addChangePriceButton();

    }

    public void addVendingModel(VendingModel vendingModel) {
        this.vendingModel = vendingModel;
    }

    public MaintenanceView getMaintenanceView() {
        return maintenanceView;
    }

    public void addPrintReportListener() {
        maintenanceView.addPrintReportButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setReportLabels();
                maintenanceView.setVisible(false);
                printReport.setVisible(true);
            }
        });
    }

    public void addGetChangeListener() {
        maintenanceView.addGetChangeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGetChangeLabel();
                maintenanceView.setVisible(false);
                getChange.setVisible(true);
            }
        });
    }

    public void addChangePriceListener() {
        maintenanceView.addChangePriceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maintenanceView.setVisible(false);
                changePriceView.setVisible(true);
            }
        });
    }

    public void addRestockListener() {
        maintenanceView.addRestockListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restockView.getBunlb().setText(String.valueOf(vendingModel.getSlots().get(0).getAvailability()));
                restockView.getTomatoeslb().setText(String.valueOf(vendingModel.getSlots().get(1).getAvailability()));
                restockView.getChicklb().setText(String.valueOf(vendingModel.getSlots().get(2).getAvailability()));
                restockView.getCheeselb().setText(String.valueOf(vendingModel.getSlots().get(3).getAvailability()));
                restockView.getPattylb().setText(String.valueOf(vendingModel.getSlots().get(4).getAvailability()));
                restockView.getLettucelb().setText(String.valueOf(vendingModel.getSlots().get(5).getAvailability()));
                restockView.getOnionlb().setText(String.valueOf(vendingModel.getSlots().get(6).getAvailability()));
                restockView.getFishlb().setText(String.valueOf(vendingModel.getSlots().get(7).getAvailability()));
                maintenanceView.setVisible(false);
                restockView.setVisible(true);
            }
        });
    }

    public void addRefillListener() {

        maintenanceView.addRefillListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refillView.get1label().setText(String.valueOf(vendingModel.getAvailableChange(0)));
                refillView.get5label().setText(String.valueOf(vendingModel.getAvailableChange(1)));
                refillView.get10label().setText(String.valueOf(vendingModel.getAvailableChange(2)));
                refillView.get20label().setText(String.valueOf(vendingModel.getAvailableChange(3)));
                refillView.get50label().setText(String.valueOf(vendingModel.getAvailableChange(4)));
                refillView.get100label().setText(String.valueOf(vendingModel.getAvailableChange(5)));
                refillView.get500label().setText(String.valueOf(vendingModel.getAvailableChange(6)));
                maintenanceView.setVisible(false);
                refillView.setVisible(true);
            }
        });
    }

    public void addGetChangeExit() {
        getChange.addGetChangeExit(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
                maintenanceView.setVisible(true);
            }
        });
    }

    public void addPrintReportExit() {
        printReport.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
                maintenanceView.setVisible(true);
            }
        });
    }

    public void addChangePriceExit() {
        changePriceView.addChangePriceExit(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
                maintenanceView.setVisible(true);
            }
        });
    }

    public void addRestockExit() {
        restockView.addRestockExit(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
                maintenanceView.setVisible(true);
            }
        });
    }

    public void addRefillExit() {
        refillView.addRefillExit(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
                maintenanceView.setVisible(true);
            }
        });
    }

    public void setReportLabels() {

        int j = 0, k = 0,total=0;
        for (Component i : printReport.getPrintReport().getComponents()) {
            if (i instanceof JLabel)
            {
                if (j > 0 && j < 9)
                {
                    if (k == 0)
                    {
                        ((JLabel) i).setText(vendingModel.getSlots().get(j - 1).getName());
                    }
                    else if (k == 1)
                    {
                        ((JLabel) i).setText(String.valueOf(vendingModel.getSlots().get(j - 1).getAvailability() + vendingModel.getSlots().get(j - 1).getSold()));
                    }
                    else if (k == 2)
                    {
                        ((JLabel) i).setText(String.valueOf(vendingModel.getSlots().get(j - 1).getAvailability()));
                    }
                    else if (k == 3)
                    {
                        ((JLabel) i).setText(String.valueOf(vendingModel.getSlots().get(j - 1).getSold()));
                    }
                    else if (k == 4)
                    {
                        ((JLabel) i).setText(String.valueOf(vendingModel.getSlots().get(j - 1).getSale()));
                        total += vendingModel.getSlots().get(j - 1).getSale();
                        k = -1;
                        j++;
                    }
                    k++;
                }
                else if (j == 0) {
                    if (k == 0) {
                        ((JLabel) i).setText("Items");
                    } else if (k == 1) {
                        ((JLabel) i).setText("Stock Before");
                    } else if (k == 2) {
                        ((JLabel) i).setText("Stock Now");
                    } else if (k == 3) {
                        ((JLabel) i).setText("Number of sold Items");
                    } else if (k == 4) {
                        ((JLabel) i).setText("Total Sales");
                        k = -1;
                        j = 1;
                    }
                    k++;
                }
                else if(j>8)
                {
                    if(k==0)
                    {
                        ((JLabel) i).setText("Total Vending Sales:");
                        k++;
                    }
                    else if(k==1)
                    {
                        ((JLabel) i).setText(String.valueOf(total));
                        k++;
                    }
                }
            }
        }
    }
    public void setGetChangeLabel()
    {
        double change=0;
        for (int i = 0; i<vendingModel.getSlots().size();i++)
        {
            change += vendingModel.getSlots().get(i).getSale();
            vendingModel.getSlots().get(i).setSale(0);
        }
        getChange.getAmountLabel().setText(String.valueOf(change));
    }
    public void addRefillButtons()
    {
        refillView.addRefillButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == refillView.getA1Button())
                {
                    vendingModel.setAvailableChange(1+ vendingModel.getAvailableChange(0),0);
                    refillView.get1label().setText(String.valueOf(vendingModel.getAvailableChange(0)));
                }
                else if (e.getSource() == refillView.getA5Button())
                {
                    vendingModel.setAvailableChange(1+ vendingModel.getAvailableChange(1),1);
                    refillView.get5label().setText(String.valueOf(vendingModel.getAvailableChange(1)));
                }
                else if (e.getSource() == refillView.getA10Button())
                {
                    vendingModel.setAvailableChange(1+ vendingModel.getAvailableChange(2),2);
                    refillView.get10label().setText(String.valueOf(vendingModel.getAvailableChange(2)));
                }
                else if (e.getSource() == refillView.getA20Button())
                {
                    vendingModel.setAvailableChange(1+ vendingModel.getAvailableChange(3),3);
                    refillView.get20label().setText(String.valueOf(vendingModel.getAvailableChange(3)));
                }
                else if (e.getSource() == refillView.getA50Button())
                {
                    vendingModel.setAvailableChange(1+ vendingModel.getAvailableChange(4),4);
                    refillView.get50label().setText(String.valueOf(vendingModel.getAvailableChange(4)));
                }
                else if (e.getSource() == refillView.getA100Button())
                {
                    vendingModel.setAvailableChange(1+ vendingModel.getAvailableChange(5),5);
                    refillView.get100label().setText(String.valueOf(vendingModel.getAvailableChange(5)));
                }
                else if (e.getSource() == refillView.getA500Button())
                {
                    vendingModel.setAvailableChange(1+ vendingModel.getAvailableChange(6),6);
                    refillView.get500label().setText(String.valueOf(vendingModel.getAvailableChange(6)));
                }
            }
        });
    }
    public void addRestockButton()
    {
        restockView.addRestockButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == restockView.getBunButton())
                {
                    vendingModel.getSlots().get(0).setAvailability(1+ vendingModel.getSlots().get(0).getAvailability());
                    restockView.getBunlb().setText(String.valueOf(vendingModel.getSlots().get(0).getAvailability()));
                    resetPrintReport();
                }
                else if (e.getSource() == restockView.getTomatoesButton())
                {
                    vendingModel.getSlots().get(1).setAvailability(1+ vendingModel.getSlots().get(1).getAvailability());
                    restockView.getTomatoeslb().setText(String.valueOf(vendingModel.getSlots().get(1).getAvailability()));
                    resetPrintReport();
                }
                else if (e.getSource() == restockView.getChickenFilletButton())
                {
                    vendingModel.getSlots().get(2).setAvailability(1+ vendingModel.getSlots().get(2).getAvailability());
                    restockView.getChicklb().setText(String.valueOf(vendingModel.getSlots().get(2).getAvailability()));
                    resetPrintReport();
                }
                else if (e.getSource() == restockView.getMozarellaButton())
                {
                    vendingModel.getSlots().get(3).setAvailability(1+ vendingModel.getSlots().get(3).getAvailability());
                    restockView.getCheeselb().setText(String.valueOf(vendingModel.getSlots().get(3).getAvailability()));
                    resetPrintReport();
                }
                else if (e.getSource() == restockView.getPattyButton())
                {
                    vendingModel.getSlots().get(4).setAvailability(1+ vendingModel.getSlots().get(4).getAvailability());
                    restockView.getPattylb().setText(String.valueOf(vendingModel.getSlots().get(4).getAvailability()));
                    resetPrintReport();
                }
                else if (e.getSource() == restockView.getLettuceButton())
                {
                    vendingModel.getSlots().get(5).setAvailability(1+ vendingModel.getSlots().get(5).getAvailability());
                    restockView.getLettucelb().setText(String.valueOf(vendingModel.getSlots().get(5).getAvailability()));
                    resetPrintReport();
                }
                else if (e.getSource() == restockView.getOnionButton())
                {
                    vendingModel.getSlots().get(6).setAvailability(1+ vendingModel.getSlots().get(6).getAvailability());
                    restockView.getOnionlb().setText(String.valueOf(vendingModel.getSlots().get(6).getAvailability()));
                    resetPrintReport();
                }
                else if (e.getSource() == restockView.getFishFilletButton())
                {
                    vendingModel.getSlots().get(7).setAvailability(1+ vendingModel.getSlots().get(7).getAvailability());
                    restockView.getFishlb().setText(String.valueOf(vendingModel.getSlots().get(7).getAvailability()));
                    resetPrintReport();
                }
            }
        });
    }
    public void resetPrintReport()
    {
        for(int i=0; i< vendingModel.getSlots().size();i++)
        {
            vendingModel.getSlots().get(i).setSold(0);
            vendingModel.getSlots().get(i).setSale(0);
        }
    }
    public void addChangePriceButton()
    {
        final int[] changeprice = new int[1];
        changeprice[0] = 9;

        changePriceView.addChangePriceButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == changePriceView.getBunButton())
                {
                    changeprice[0] =0;
                    setAllButtonFalse(changePriceView.getChangePricePanel());
                    changePriceView.getBunButton().setEnabled(true);
                    changePriceView.getChangePriceButton().setEnabled(true);
                }
                else if (e.getSource() == changePriceView.getTomatoesButton())
                {
                    changeprice[0] =1;
                    setAllButtonFalse(changePriceView.getChangePricePanel());
                    changePriceView.getTomatoesButton().setEnabled(true);
                    changePriceView.getChangePriceButton().setEnabled(true);
                }
                else if (e.getSource() == changePriceView.getChickenFilletButton())
                {
                    changeprice[0] =2;
                    setAllButtonFalse(changePriceView.getChangePricePanel());
                    changePriceView.getChickenFilletButton().setEnabled(true);
                    changePriceView.getChangePriceButton().setEnabled(true);
                }
                else if (e.getSource() == changePriceView.getMozarellaButton())
                {
                    changeprice[0] =3;
                    setAllButtonFalse(changePriceView.getChangePricePanel());
                    changePriceView.getMozarellaButton().setEnabled(true);
                    changePriceView.getChangePriceButton().setEnabled(true);
                }
                else if (e.getSource() == changePriceView.getPattyButton())
                {
                    changeprice[0] =4;
                    setAllButtonFalse(changePriceView.getChangePricePanel());
                    changePriceView.getPattyButton().setEnabled(true);
                    changePriceView.getChangePriceButton().setEnabled(true);
                }
                else if (e.getSource() ==changePriceView.getLettuceButton())
                {
                    changeprice[0] =5;
                    setAllButtonFalse(changePriceView.getChangePricePanel());
                    changePriceView.getLettuceButton().setEnabled(true);
                    changePriceView.getChangePriceButton().setEnabled(true);
                }
                else if (e.getSource() == changePriceView.getOnionButton())
                {
                    changeprice[0] =6;
                    setAllButtonFalse(changePriceView.getChangePricePanel());
                    changePriceView.getOnionButton().setEnabled(true);
                    changePriceView.getChangePriceButton().setEnabled(true);
                }
                else if (e.getSource() == changePriceView.getFishFilletButton())
                {
                    changeprice[0] =7;
                    setAllButtonFalse(changePriceView.getChangePricePanel());
                    changePriceView.getFishFilletButton().setEnabled(true);
                    changePriceView.getChangePriceButton().setEnabled(true);
                } else if (e.getSource() == changePriceView.getChangePriceButton())
                {
                    String input = changePriceView.getPriceTextField().getText().trim();
                    if(changeprice[0]==9)
                    {
                        changePriceView.getPriceChangeLb().setText("Click a product to change price!");
                    }
                    else if(isInteger(input)==true&&changeprice[0]!=9)
                    {
                        vendingModel.getSlots().get(changeprice[0]).setPrice(Integer.parseInt(input));
                        changePriceView.getPriceChangeLb().setText(vendingModel.getSlots().get(changeprice[0]).getName()+" price was changed to "+ input+"php");
                        setAllButtonTrue(changePriceView.getChangePricePanel());
                        changeprice[0]=9;


                    }

                    else if(isInteger(input)==false&&changeprice[0]!=9) {
                        changePriceView.getPriceChangeLb().setText(vendingModel.getSlots().get(changeprice[0]).getName()+" price was not changed, please input an integer in the text field.");
                        setAllButtonTrue(changePriceView.getChangePricePanel());
                        changeprice[0]=9;
                    }

                }
            }
        });
    }
    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void setAllButtonTrue(JPanel jPanel)
    {
        for(Component i : jPanel.getComponents())
        {
            if(i instanceof JButton)
            {
                ((JButton) i).setEnabled(true);
            }
        }
    }
    public void setAllButtonFalse(JPanel jPanel)
    {
        for(Component i : jPanel.getComponents())
        {
            if(i instanceof JButton)
            {
                ((JButton) i).setEnabled(false);
            }
        }
    }
}

