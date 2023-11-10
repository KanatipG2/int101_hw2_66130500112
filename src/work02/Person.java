package work02;
import work01.Utilitor;
public class Person {
    private static int nextId = 1;
    private final int id;
    private String firstname;
    private String lastname;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        try {
            Utilitor.testString(firstname);
            Utilitor.testString(lastname);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        id = nextId;
        nextId++;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Person()");
        str.insert(7,lastname);
        str.insert(7,",");
        str.insert(7,firstname);
        str.insert(7,",");
        str.insert(7,id);
        return str.toString();
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        try {
            Utilitor.testString(firstname);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Person person)) {
            return false;
        }

        return id == person.getId() && firstname.equals(person.getFirstname())
                && lastname.equals(person.getLastname());
    }
}
