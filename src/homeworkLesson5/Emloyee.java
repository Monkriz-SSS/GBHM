package homeworkLesson5;

public class Emloyee {

    private String name;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;


    Emloyee(String name, String position, String email, String phone, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public static void getFullInfo(Emloyee emloyee) {
        System.out.println("Имя сотрудника - " + emloyee.getName() + "\n" + "Должность - " + emloyee.getPosition() + "\n" + "Email - " + emloyee.getEmail() + "\n" + "Телефон - " + emloyee.getPhone() + "\n" + "Зарплата - " + emloyee.getSalary() + "Возраст - " + emloyee.getAge() + "\n");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
