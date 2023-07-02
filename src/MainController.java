import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {

    private MainModel mainModel;
    private MainView mainView;

    public MainController(MainModel mainModel, MainView mainView)
    {
        this.mainModel = mainModel;
        this.mainView = mainView;
        addCreateListener();
        addTestingListener();
        addChoiceListener();

    }

    public void addCreateListener()
    {
        mainView.addCreateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainView.getMain().setVisible(false);
                mainView.getChoose().setVisible(true);
                mainView.pack();

            }
        });
    }

    public void addTestingListener()
    {
        mainView.addTestingListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainModel.getVendingChoice() == 1) // regular vending machine chosen
                {
                    mainModel.getVendingMachine().viewVendingMachine();
                }
                else if (mainModel.getVendingChoice() == 2) // special vending machine chosen
                {
                    mainModel.getSpecialVendingMachine().viewVendingMachine();;
                }
            }
        });
    }

    public void addChoiceListener()
    {
        mainView.addChoiceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Regular vending machine"))
                {
                    mainModel.initializeRegularVending();
                    mainModel.regularExist();
                }
                else if (e.getActionCommand().equals("Special vending machine"))
                {
                    mainModel.initializeSpecialVending();
                    mainModel.specialExist();
                }
                mainView.getChoose().setVisible(false);
                mainView.getMain().setVisible(true);
                mainView.getTestVending().setEnabled(true);
                mainView.pack();
            }
        });
    }
}
