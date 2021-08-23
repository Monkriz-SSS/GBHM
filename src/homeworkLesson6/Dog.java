package homeworkLesson6;

public class Dog extends Animal {

   static int checkDogs = 0;

    int runMaxValue = 500;
    int swimMaxValue = 10;

    Dog(String name) {
        super(name);
        checkDogs++;
    }

    public void run(int m) {
        if (m <= runMaxValue) {
            System.out.println(name + " пробежал " + m + "м.");
        } else {
            System.out.println(name + " пробежал " + runMaxValue + "м." + " и сдох.");
        }
    }

    public void swim(int m) {
        if (m <= swimMaxValue) {
            System.out.println(name + " проплыл " + m + "м.");
        } else {
            System.out.println(name + " проплыл " + swimMaxValue + "м." + " и утонул.");
        }
    }
}
