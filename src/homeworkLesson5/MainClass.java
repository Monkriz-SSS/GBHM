package homeworkLesson5;
import static homeworkLesson5.Emloyee.*;

public class MainClass {

    public static void main(String[] args) {

        Emloyee[] array = new Emloyee[5];

        array[0]= new Emloyee("Фролов Олег Юрьевич", "Прораб", "ololoika@lolo.com", "89990987865", 40000, 45);
        array[1]= new Emloyee("Дерипаска Паска Ка", "Директор", "akujava@lolo.com", "89996547384", 4000000, 55);
        array[2]= new Emloyee("Мимо Проходивший Человек", "Курьер", "donesu@lolo.com", "89990002233", 25000, 19);
        array[3]= new Emloyee("Арнольд Витальевич Шварцбелый", "Грузчик", "podnimu@lolo.com", "89997896541", 46000, 34);
        array[4]= new Emloyee("Жил Был Недолго", "Предсказатель", "vsempi@lolo.com", "84956660666", 12342, 134);

        for (Emloyee e : array){
            if (e.getAge()>40){
                getFullInfo(e);
            }
        }

    }

}
