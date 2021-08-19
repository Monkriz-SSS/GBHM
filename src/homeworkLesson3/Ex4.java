package homeworkLesson3;

public class Ex4 {

    public static void main(String[] args) {

        int[][] array = new int[10][10];

        diagonal(array);

    }

    public static void diagonal(int[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = 1;
                }
            }
        }

        int count = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            array[i][count] = 1;
            count++;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}
