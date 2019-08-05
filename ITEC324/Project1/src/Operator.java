/**
 * Created by James Bond on 2/14/2016.
 */
public class Operator {

    private VMStorageArray storage;


    public Operator(VMStorageArray _storage) {

        storage = _storage;
        addSnacks();
        removeMoney();
    }

    private void removeMoney() {
    }


    public void addSnacks() {

        storage.loadSnacks();
    }

    public VMStorageArray getStorage() {
        return storage;
    }
}
