package array;

public class dynamicArray {
    private int[] array;
    private int length;
    private int idx;

    public dynamicArray(int size) {
        this.length = size; // no need for that
        this.array = new int[this.length];
        this.idx = 0;
    }

    public void insert(int item) {
        if (this.idx < array.length) {
            this.array[idx++] = item;
        } else {
            // create new array
            int[] newArray = new int[length + 1];
            // copy old array item to the new one
            if (length >= 0) System.arraycopy(array, 0, newArray, 0, length);
            // add the new item
            newArray[idx++] = item;
            this.array = newArray;
            this.length = newArray.length;
        }
    }

    public void removeAt(int index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i+1];
        }
        int[] newArray = new int[length - 1];

        System.arraycopy(array, 0, newArray, 0, newArray.length);

        this.array = newArray;
        this.length = newArray.length;
    }

    public int indexOf(int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int number : this.array) {
            System.out.println(number);
        }
    }
}
