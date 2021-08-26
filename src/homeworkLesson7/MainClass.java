package homeworkLesson7;
import static homeworkLesson7.Names.randomName;

public class MainClass {
        public static void main(String[] args) {
            Plate plate = new Plate(50);
            Cat [] cats = new Cat[10];
            for (int i = 0; i < cats.length; i++) {
                cats[i]=new Cat(randomName(),(int) (Math.random()*15));
            }

            for (Cat cat : cats) {
                if (plate.isYesNo()==false){
                    break;
                }   else {
                    cat.eat(plate);
                }
            }

            for (Cat cat: cats) {
                cat.catInfo();
            }
            System.out.println();

            plate.info();
        }
    }


