package homeworkLesson6;
import static homeworkLesson6.Animal.*;
public class MainClass {

    public static void main(String[] args) {

        Cat cat = new Cat("Barsik");
        cat.run(1100);
        cat.swim(50);

        Cat cat1=new Cat("Ari");
        Cat cat2=new Cat("Ari");
        Cat cat3=new Cat("Ari");
        Cat cat4=new Cat("Ari");

        Dog dog = new Dog("Bulka");
        dog.run(1200);
        dog.swim(150);

        cat.checkCatsInfo();

        checkAnimalsInfo();

    }

}
