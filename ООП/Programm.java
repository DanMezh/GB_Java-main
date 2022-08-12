import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {

        Person natasha = new Person("Наташа");
        Person alex = new Person("Саша");
        Person mary = new Person("Маша");
        Person n021 = new Person("Алла");
        Person n022 = new Person("Иван");
        Person n011 = new Person("Валера");

        natasha.appendToFamily(alex);
        natasha.appendToFamily(mary);
        alex.appendToFamily(n011);
        mary.appendToFamily(n021);
        mary.appendToFamily(n022);

        Research(natasha, "");
    }

    static void Research(Person root, String sp) {
        if (root != null) {
            System.out.println(sp + root.fullName);
            for (Person item : root.getFamily()) {
                Research(item, sp + "  ");
            }
        }
    }
}

class Person {

    public String fullName;

    private ArrayList<Person> family = new ArrayList<>();

    public ArrayList<Person> getFamily() {
        return family;
    }

    public void appendToFamily(Person p) {
        family.add(p);
    }

    public Person(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}