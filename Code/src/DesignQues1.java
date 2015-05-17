import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sarim on 15-05-16.
 */
public class DesignQues1 {
    public int[] char_set;
    public boolean[] value_set;
    public String word;

    public void prepareASCII() {
        for (int i = 0; i < word.length(); i++)
            char_set[i] = (int) (word.charAt(i));
    }

    public void checkUnique() {
        for (int i = 0; i < word.length(); i++) {
            if (value_set[char_set[i]])//If the value exists; mark the location as false
                value_set[char_set[i]] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner obj = new Scanner(System.in);
        DesignQues1 DQ = new DesignQues1();

        DQ.word = obj.next();
        DQ.char_set = new int[DQ.word.length()];
        DQ.value_set = new boolean[256];
        Arrays.fill(DQ.value_set, true); //Initially all are true
        int count = 0;

        DQ.prepareASCII();
        DQ.checkUnique();

        for (int i = 0; i < DQ.value_set.length; i++) {
            if (!DQ.value_set[i])
                count++; //Count the number of falses in the array
        }
        System.out.print(count);
    }
}
