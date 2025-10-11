package ua.opnu;

public class Main {
    public static void main(String[] args) {

        Person[] people = new Person[4];

        people[0] = new Person("Іваненко", "Олег", 40);
        people[1] = new Student("Петренко", "Марія", 19, "КН-23", "ST12345");
        people[2] = new Student("Сидоренко", "Ігор", 20, "КІ-22", "ST67890");
        people[3] = new Lecturer("Ткаченко", "Оксана", 35, "Комп’ютерних наук", 28500.0);

        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}