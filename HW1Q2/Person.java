public class Person {
    // Properties
    private String firstName;
    private String lastName;
    private String id; 

    // Constructor
    public Person(String fname, String lname, String id) {
        this.firstName = fname;
        this.lastName = lname;
        this.id = id;
    }

    // Accessor Methods
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String fname) {
        this.firstName = fname;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lname) {
        this.lastName = lname;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Overriding toString method to convert the object to a string representation
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " (" + this.id + ")";
    }

    // Main method for testing the class
    public static void main(String[] args) {
        Person bhumika = new Person("Bhumika", "Basnet", "1");
        System.out.println(bhumika.toString());
    }
}
