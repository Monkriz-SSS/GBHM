package homeworkLesson3;


    public class Ex6 {

        public static void main(String[] args) {

            int[] array = new int[200];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 600);
            }

            minMax(array);

        }

        public static void minMax(int[] array) {

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < array.length; i++) {

                if (array[i] < min) {
                    min = array[i];
                }

                if (array[i] > max) {
                }
                max = array[i];
            }

            System.out.println("Минимальный элемент массива - " + min);
            System.out.println("Максимальный элемент массива - " + max);

        }

    }


