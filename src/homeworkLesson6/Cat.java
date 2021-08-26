package homeworkLesson6;

public class Cat extends Animal {

    static int checkCats = 0;
    int runMaxValue = 200;

    Cat(String name) {
        super(name);
        checkCats++;
    }

    public void run(int m) {
        if (m<=runMaxValue){
        System.out.println(name + " пробежал " + m + "м.");}
        else {
            System.out.println(name + " пробежал " + runMaxValue + "м." + " и сдох.");
        }
    }


    public void swim(int m) {
        System.out.println(name + " не умеет плавать.");
    }

    public void checkCatsInfo (){
        System.out.println(checkCats);
    }

}
