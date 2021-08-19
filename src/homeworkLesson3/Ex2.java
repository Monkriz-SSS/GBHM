package homeworkLesson3;

public class Ex2 {

    public static void main(String[] args) {

        int[] array = new int[100];
        int count = 1;

        for (int i = 0; i < array.length; i++) {
            array[i] = count;
            count++;
        }

        for (int a : array) {
            System.out.print(a + " ");
        }

    }

}
