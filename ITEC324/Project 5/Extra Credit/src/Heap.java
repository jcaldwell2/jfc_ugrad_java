import java.util.Arrays;

/**
 * Created by James on 5/4/2016.
 */
public class Heap {


    /**
     * The Heap.
     */
    public ListNode[] heap;
    public int size;
    private int maxSize = 25;
    private String outString;
    private int smallestIndex;

    /**
     * Instantiates a new Heap.
     *
     * @param _heap the heap
     */
    public Heap(ListNode[] _heap){this.heap = _heap; setSize(); heapify(0);}


    /**
     * Remove max list node.
     *
     * @return the list node
     */
    public ListNode removeMax()
    {
        ListNode rootNode = heap[0];
        heap[0] = heap[--size];
        bubbleDown(0);
        heap[size] = null;
        return rootNode;
    }

    /**
     * Remove min list node.
     *
     * @return the list node
     */
    public ListNode removeMin()
    {
        if(!isEmpty()) {
            ListNode rootNode = heap[0];
            smallest();
            heap[smallestIndex] = heap[--size];

            bubbleDown(0);
            heap[size] = null;

            return rootNode;
        }else{ return null;}
    }


    /**
     * Smallest int.
     *
     * @return the int
     */
    public int smallest(){
        int smallest = heap[0].getVal();
        if(!isEmpty()){
            for (ListNode node : heap) {
                if(node != null)
                if(node.getVal() < smallest ){
                    smallest = node.getVal();
                    smallestIndex = Arrays.asList(heap).indexOf(node);
                }
            }
        } return smallest;

    }


    /**
     * Bubble down.
     *
     * @param index the index
     */
    public void bubbleDown(int index)
    {
        int	largerChild;
        ListNode top = heap[index];
        while (index < size/2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < size &&
                    heap[leftChild].getVal() <
                            heap[rightChild].getVal()) {
                largerChild = rightChild;
                swapValue(heap[largerChild].getVal(), heap[rightChild].getVal());
            }else{
            largerChild = leftChild;
                swapValue(heap[largerChild].getVal(), heap[leftChild].getVal());
        }
            if (top.getVal() >= heap[largerChild].getVal())
                break;

            heap[index] = heap[largerChild];
            index = largerChild;
        }
        heap[index] = top;
    }

    /**
     * Bubble up from the index.
     *
     * @param index the index
     */
    public void bubbleUp(int index)
    {
        int parent = (index - 1)/2;
        ListNode bottom = heap[index];

        while(index > 0 && heap[parent].getVal() < bottom.getVal())
        {
            heap[index] = heap[parent];
            index = parent;
            parent = (parent -1)/2;
        }
        heap[index] = bottom;
    }

    /**
     * Swap value boolean.
     *
     * @param index    the index
     * @param newValue the new value
     * @return the boolean
     */
    public Boolean swapValue(int index, int newValue)
    {
        if (index < 0 || index >= size)
            return false;
        int oldValue =
        heap[index].getVal();
        heap[index].setVal(newValue);

        if (oldValue < newValue)
            bubbleUp(index);
        else
            bubbleDown(index);
        return true;
    }

    /**
     * Add boolean.
     *
     * @param i the
     * @return the boolean
     */
    public Boolean add(int i)
    {
        if (size == maxSize)
            return false;
        ListNode newNode = new ListNode(i);
        heap[size] = newNode;
        bubbleUp(size++);


        return true;
    }

    public void heapify(int index)
    {
        if (index > size/2-1)
            return;
        heapify(index*2+2);
        heapify(index*2+1);
        bubbleDown(index);
    }


    /**
     * Sets size.
     */
    public void setSize() {
        int counter = 0;
        for (int i = 0; i < heap.length; i++)
            if (heap[i] != null)
                counter++;
        this.size = counter;
    }

    /**
     * Print heap.
     */
    public void printHeap(){


        outString = "";
        for (ListNode node : heap) {

            if (node == null) {

            } else {
                outString += node.toString();
            }
        }

        System.out.println(outString + "\n");

        outString = "";

    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty(){

        return (size == 0);
    }

}
