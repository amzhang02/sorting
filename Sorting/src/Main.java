import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        testSort(20);

    }
    public static void testSort(int length) {
        Sorter alyssaSorter = new Sorter();
        Random random = new Random();
        List<Integer> nums = new ArrayList<>();
        for (int i=0; i<length; i++) {
            nums.add(random.nextInt(2000000000));
        }
        List<Integer> copyNums = new ArrayList<>(nums);
        java.util.Collections.sort(copyNums);
        long startTime = System.currentTimeMillis();

        alyssaSorter.selectionSort(nums);   // if your sort function sorts the list in-place
        // or
        //nums = alyssaSorter.mergeSort(nums);  // if your sort function returns a new list

        long stopTime = System.currentTimeMillis();
        double duration = (double) ((stopTime-startTime) / 1000.0);
        boolean foundBadNum = false;
        for (int i=0; i<copyNums.size(); i++) {
            if (!(nums.get(i).equals(copyNums.get(i)))) {
                foundBadNum = true;
            }
        }
        if (foundBadNum) {
            System.out.print("sorting failed ");
        } else {
            System.out.print("sorting succeeded! ");
        }
        System.out.println("in " + duration + " seconds");
    }
}
