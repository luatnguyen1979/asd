package usa.edu.mum.asd.lectures.lec3.prototype;

public class Person implements Prototype {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public Prototype doClone() {
        return new Person(name);
    }

    public String toString() {
        return "This person is named " + name;
    }
}