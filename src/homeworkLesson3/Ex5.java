package homeworkLesson3;

import java.util.Arrays;

public class Ex5 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(massiv(10, 25)));
    }


    public static int[] massiv(int len, int initialValue) {

        int array[] = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

}
