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
                maintenanceView.setVisible(false);
                restockView.setVisible(true);
            }
        });
    }

    public void addRefillListener() {
        maintenanceView.addRefillListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
}

