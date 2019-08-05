import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by James on 5/4/2016.
 */
public class HeapSorter {


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {

        String input = "";

     //   ListNode[] heapArray1 = new ListNode[20];
        ListNode[] heapArray2 = new ListNode[20];
        /*Heap heap1 = new Heap(heapArray1);

        heap1.add(12);
        heap1.add(28);
        heap1.add(25);
        heap1.add(10);
        heap1.add(18);

        heap1.printHeap();
        heap1.removeMin();
        heap1.printHeap();12
        heap1.add(45);
        heap1.add(68);
        heap1.printHeap();
*/

        Heap heap2 = new Heap(heapArray2);

        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        try {
            while ((input = BR.readLine()) != null) {

               // System.out.println(input); --for testing the input

                try {
                    heap2.add(Integer.parseInt(input));
                } catch (NumberFormatException e) {
                   System.out.println("Enter a number please \n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Heapify");
        heap2.heapify(heap2.size);
         heap2.printHeap();
        System.out.println("Remove smallest");
        heap2.removeMin();
        heap2.printHeap();
        System.out.println("Finished");

    }

}

