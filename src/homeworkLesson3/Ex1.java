package homeworkLesson3;

public class Ex1 {

    public static void main(String[] args) {

        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 2);
        }

        for (int a : array) {
            System.out.print(a + " ");
        }

        System.out.println();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }

        for (int a : array) {
            System.out.print(a + " ");
        }

    }

}
