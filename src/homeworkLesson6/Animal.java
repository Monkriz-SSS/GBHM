package homeworkLesson6;

public abstract class Animal {

    public static int checkAnimals = 0;
    protected String name;

    Animal(String name) {
        this.name = name;
        checkAnimals++;
    }

    public abstract void run(int m);

    public abstract void swim(int m);

    public static void checkAnimalsInfo () {
        System.out.println(checkAnimals);
    }

}
