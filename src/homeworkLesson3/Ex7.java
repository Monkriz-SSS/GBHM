package homeworkLesson3;

public class Ex7 {

    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(whatIsIt(array));
        int[] array2 = new int[]{3, 5, 6, 234, 6, 25, 23, 123, 4326, 7234};
        System.out.println(whatIsIt(array2));
        int[] array3 = new int[]{1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1};
        System.out.println(whatIsIt(array3));
    }

    public static boolean whatIsIt(int[] a) {

        boolean result = false;
        int start = 0;
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            start += a[i];
            for (int j = i + 1; j < a.length; j++) {
                temp += a[j];
            }
            if (start == temp) {
                result = true;
            } else {
                temp = 0;
            }
        }
        return result;

    }

}
