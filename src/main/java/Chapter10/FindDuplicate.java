package Chapter10;

/**
 * Created by bresai on 2017/3/3.
 */
public class FindDuplicate {
    private Bitset bitset;

    public void findDuplicates(int[] array){
        bitset = new Bitset(32000);
        for (int value : array){
            if (bitset.get(value - 1)) System.out.print(value);
            else bitset.set(value - 1);
        }
    }
}

class Bitset{
    private int[] table;

    public Bitset(int size) {
        this.table = new int[(size >> 5) + 1];
    }

    public boolean get(int index){
        int bitIndex = index % 32;
        int arrayIndex = index >> 5;

        return (table[arrayIndex] & (1 << bitIndex)) != 0;
    }

    public void set(int index){
        int bitIndex = index % 32;
        int arrayIndex = index >> 5;

        table[arrayIndex] |= (1 << bitIndex);
    }
}
