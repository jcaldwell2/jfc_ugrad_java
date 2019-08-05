/**
 * Created by James Bond on 2/14/2016.
 */
public class VMController {

    private VMStorageArray storage;
    private int col;
    private int row;

    private UserInterface UI;
    private VMInput input;
    private Operator operator;


    /**
     * Start.
     */
    public void start() {

        storage = new VMStorageArray(row, col);
        UI = new UserInterface();
        input = new VMInput(storage);
        operator = new Operator(storage);

        returnChange();

    }

    private void returnChange() {
    }
}
