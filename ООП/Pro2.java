import java.util.ArrayList;
import java.util.LinkedList;

public class Pro {

    public static void main(String[] args) {
        var irina = new NewPerson("Ирина");

        var vasya = new Person("Вася");
        var masha = new Person("Маша");
        var jane = new NewPerson("Женя");
        var ivan = new NewPerson("Ваня");

        GeoTree gt = new GeoTree();
        gt.append(irina, vasya);
        gt.append(irina, masha);
        gt.append(vasya, jane);
        gt.append(vasya, ivan);

        NewGeoTree ngt = new NewGeoTree();

        // var repo = new Repository(new FileList());
        // repo.pd(irina, masha);

        //
        System.out.println(
                new Reserch(gt).spend(new Cat(), Relationship.parent));

    }

}

enum Relationship {
    parent,
    children
}

interface Human {
    String getFullName();
}

class Cat implements Human {
    @Override
    public String getFullName() {

        return "Ирина";
    }
}

class Person implements Human {

    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public Person(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {

        return getFullName();
    }
}

class NewPerson extends Person implements Human {

    String fName, lName;

    public NewPerson(String fullName) {
        super(fullName);
        fName = fullName;
        // lName = lastName;

    }

    public NewPerson(String firstName, String lastName) {
        super(firstName + lastName);
        fName = firstName;
        lName = lastName;
    }

    @Override
    public String getFullName() {

        var r = String.format("%s", fName);
        return fName;
    }

    @Override
    public String toString() {

        return getFullName();
    }
}

class Node {

    public Node(Person p1, Relationship re, Person p2) {
        this.p1 = p1;
        this.re = re;
        this.p2 = p2;
    }

    Person p1;
    Relationship re;
    Person p2;

    @Override
    public String toString() {
        return String.format("<%s %s %s>", p1, re, p2);
    }
}

interface PlusData {
    void append(Person parent, Person children);

    ArrayList<Node> getData();
}

class GeoTree implements PlusData {
    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getData() {
        return tree;
    }

    public void append(Person parent, Person children) {

        tree.add(new Node(parent, Relationship.parent, children));
        tree.add(new Node(children, Relationship.children, parent));
    }
}

class NewGeoTree implements PlusData {
    private LinkedList<Node> tree = new LinkedList<>();

    @Override
    public ArrayList<Node> getData() {

        ArrayList<Node> res = new ArrayList<>();

        for (Node node : tree) {
            res.add(node);
        }

        return res;
    }

    public void append(Person parent, Person children) {

        tree.add(new Node(parent, Relationship.parent, children));
    }
}

class FileList implements PlusData {
    @Override
    public void append(Person parent, Person children) {

    }

    @Override
    public ArrayList<Node> getData() {
        // TODO Auto-generated method stub
        return null;
    }
}

// class Repository {
// PlusData pd;

// public Repository(PlusData plusData) {
// pd = plusData;
// }

// public void appandPair(Person p, Person c) {
// pd.append(p, c);
// }
// }

class Reserch {
    ArrayList<Node> tree;

    public Reserch(PlusData pd) {
        tree = pd.getData();
    }

    public ArrayList<Person> spend(Human p, Relationship re) {

        var result = new ArrayList<Person>();

        // tree.forEach((t) -> {
        // if (t.p1.fullName == p.fullName
        // && t.re == re) {
        // result.add(t.p2);
        // }
        // });

        for (Node t : tree) {
            // System.out.println(t.p1.getFullName());
            // System.out.println(p.getFullName());
            if (t.p1.getFullName() == p.getFullName()
                    && t.re == re) {
                result.add(t.p2);
            }
        }

        return result;
    }
}

class Printer {

}
