package homeworkLesson7;

import java.util.Scanner;

public class Plate {
    private int food;
    private final int startFood;
    private boolean yesNo = true;

    public boolean isYesNo() {
        return yesNo;
    }

    public Plate(int food) {
        this.startFood = food;
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food > n) {
            food -= n;
            return true;
        } else {
            humanAdd();
            if (yesNo == false) {
                System.out.println("Мы не стали кормить ваших котов!\n");
                return false;
            } else {
                food -= n;
                return true;
            }
        }
    }

    public void info() {

        System.out.println("В тарелке осталось: " + food + " еды.");
    }

    public void humanAdd() {
        System.out.println("Напишите yes, если хотите пополнить тарелку или коты останутся голодными.");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("yes")) {
            food = startFood;
            yesNo = true;
        } else {
            yesNo = false;
        }
        System.out.println();
        scanner.close();
    }
}


