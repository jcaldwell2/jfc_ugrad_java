/**
 * Created by James Bond on 2/14/2016.
 */
public class VMInput {

    private VMStorageArray storage;

    public VMInput(VMStorageArray _storage) {

        storage = _storage;
        makeSelection();
    }

    public VMStorageArray getStorage() {
        return storage;
    }


    public void makeSelection() {
        returnChange();
    }

    public void returnChange() {


    }
}
