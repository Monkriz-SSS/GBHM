package homeworkLesson3;

public class Ex8 {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int a : array) {
            System.out.print(a + " ");
        }

        System.out.println();

        sdvig(array, 3);

        for (int a : array) {
            System.out.print(a + " ");
        }

        System.out.println();
        System.out.println();

        for (int a : array2) {
            System.out.print(a + " ");
        }

        sdvig(array2, -3);

        System.out.println();

        for (int a : array2) {
            System.out.print(a + " ");
        }

    }

    public static int[] sdvig(int[] a, int n) {

        if (n > 0) {
            for (int i = 0; i < n; i++) {

                int lastElement = a[a.length - 1];
                int temp = a[0];
                int preTemp = 0;
                for (int j = 1; j < a.length; j++) {
                    preTemp = a[j];
                    a[j] = temp;
                    temp = preTemp;
                }
                a[0] = lastElement;
            }
        }

        if (n < 0) {
            for (int i = 0; i < (n * -1); i++) {

                int firstElement = a[0];
                int temp = a[a.length - 1];
                int preTemp = 0;
                for (int j = a.length - 1; j >= 0; j--) {
                    preTemp = a[j];
                    a[j] = temp;
                    temp = preTemp;
                }
                a[a.length - 1] = firstElement;
            }
        }

        return a;
    }

}
