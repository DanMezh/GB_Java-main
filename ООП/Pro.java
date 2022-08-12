import java.util.ArrayList;

public class Pro {

    public static void main(String[] args) {
        var irina = new Person("Ирина");
        var vasya = new Person("Вася");
        var masha = new Person("Маша");
        var jane = new Person("Женя");
        var ivan = new Person("Ваня");

        GeoTree gt = new GeoTree();
        gt.append(irina, vasya);
        gt.append(irina, masha);
        gt.append(vasya, jane);
        gt.append(vasya, ivan);

        System.out.println(new Reserch(gt).spend(irina, Relationship.parent));

    }

}

enum Relationship {
    parent,
    children
}

class Person {

    protected String fullName;

    public String getFullName() {
        return fullName;
    }

    public Person(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
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

class GeoTree {
    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    public void append(Person parent, Person children) {

        tree.add(new Node(parent, Relationship.parent, children));
        tree.add(new Node(children, Relationship.children, parent));
    }
}

class Reserch {
    ArrayList<Node> tree;

    public Reserch(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    public ArrayList<Person> spend(Person p, Relationship re) {

        var result = new ArrayList<Person>();

        // tree.forEach((t) -> {
        // if (t.p1.fullName == p.fullName
        // && t.re == re) {
        // result.add(t.p2);
        // }
        // });

        for (Node t : tree) {
            if (t.p1.fullName == p.fullName
                    && t.re == re) {
                result.add(t.p2);
            }
        }

        return result;
    }
}

class Reserch2 {
    ArrayList<Node> tree;

    public Reserch2(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    public ArrayList<Node> spend(Person p, Relationship re) {

        var result = new ArrayList<Node>();

        // tree.forEach((t) -> {
        // if (t.p1.fullName == p.fullName
        // && t.re == re) {
        // result.add(t.p2);
        // }
        // });

        for (Node t : tree) {
            if (t.p1.fullName == p.fullName
                    && t.re == re) {
                result.add(t);
            }
        }

        return result;
    }
}

class Printer {

}

// Подумать над описанием взаиможействия
// Пользователя с банкоматом