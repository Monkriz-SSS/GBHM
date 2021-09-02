package homeworkLesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety=false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        satiety=p.decreaseFood(appetite);
    }

    public void catInfo () {
        if (satiety==true){
            System.out.println(name + " сытый.");
        } else {
            System.out.println(name + " голодный.");
        }
    }

}
