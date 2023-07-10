import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is for controlling the main model and main view component.
 *
 * @author Vladimir Tang
 */
public class MainController {

    private MainModel mainModel;
    private MainView mainView;

    /**
     * Constructor for this class.
     *
     * @param mainModel is the model component
     * @param mainView is the view component
     */
    public MainController(MainModel mainModel, MainView mainView)
    {
        this.mainModel = mainModel;
        this.mainView = mainView;
        this.mainModel.getVendingMachine().addMainSourceFrame(mainView);
        this.mainModel.getSpecialVendingMachine().addMainSourceFrame(mainView);

        mainModel.getVendingMachine().addViewingSlot();
        mainModel.getSpecialVendingMachine().addViewingSlot();
        mainModel.getVendingMachine().setVendingItemsEnabled(false);
        mainModel.getSpecialVendingMachine().setVendingItemsEnabled(false);
        mainModel.getVendingMachine().addVendingItemsButtonsListener();
        mainModel.getSpecialVendingMachine().addVendingItemsButtonsListener();



        addCreateListener();
        addTestingListener();
        addChoiceListener();

    }

    /**
     * Adds the functionality to the create vending machine button.
     * It lets the user see another set of buttons to choose from.
     */
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

    /**
     * Adds functionality to the testing vending button.
     * Once clicked, it will try to run the selected vending machine if it exists.
     */
    public void addTestingListener()
    {
        mainView.addTestingListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainModel.getVendingChoice() == 1) // regular vending machine chosen
                {
                    mainView.setVisible(false);
                    mainModel.getVendingMachine().defaultSettingsView();
                    mainModel.getVendingMachine().updateVendingItemsView();
                    mainModel.getVendingMachine().setDisplay(true);
                }
                else if (mainModel.getVendingChoice() == 2) // special vending machine chosen
                {
                    mainView.setVisible(false);
                    mainModel.getSpecialVendingMachine().defaultSettingsView();
                    mainModel.getSpecialVendingMachine().updateVendingItemsView();
                    mainModel.getSpecialVendingMachine().setDisplay(true);
                }
            }
        });
    }

    /**
     * This adds functionality to the two buttons for creating either vending machines.
     * Once one of them is clicked, it's considered created.
     */
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
