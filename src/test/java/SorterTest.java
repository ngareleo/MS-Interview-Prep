import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SorterTest {

    private final static int [][] testSamples = {
            {4, 2, 12, 3, 0, 12, 1},
            {64, 8, 32, 3, 0, 23, 22, 32, 0, 32, 232, 2, 23},
            {2, 3, 67, 23, 2},
    };

    private static boolean isSorted(int[] arr){
        int i = 0;
        while(i < arr.length - 1){
            if (arr[i] > arr[i+1])
                return false;
            i++;
        }
        return true;
    }

    @Test
    public static void isSortedTest(){
        assertTrue(isSorted(new int[]{1, 2, 3, 4, 5}));
        assertFalse(isSorted(new int[]{1, 2, 3, 2, 5}));
    }

    @Test
    public static void main(String[] args) {
        isSortedTest();
    }
}
