/**
 * Created by James on 5/4/2016.
 */
public class ListNode {


    private int val;


    /**
     * Instantiates a new List node.
     *
     * @param _val the val
     */
    public ListNode(int _val) {

        this.val = _val;
    }

    /**
     * Gets val.
     *
     * @return the val
     */
    public int getVal() {
        return val;
    }

    /**
     * Sets val.
     *
     * @param _val the val
     */
    public void setVal(int _val) {
        this.val = _val;
    }

    public String toString(){ return getVal() + " \n";}

}
