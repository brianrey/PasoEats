
/**
 * Abstract class representing a person with a name and email address.
 */
abstract class Person {
    private String name;
    private String email;

    /**
     * Constructor for a Person.
     * 
     * @param name The name of the person
     * @param email The email address of the person
     */
    public Person(String name, String email) {
        this.setName(name);
        this.setEmail(email);
    }

    /**
     * Prints the details of the person.
     */
    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }

    /**
     * Gets the name of the person.
     * 
     * @return The name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the email address of the person.
     * 
     * @return The email address of the person
     */ 
    public String getEmail() {
        return email;
    }

    /**
     * Sets the name of the person.
     * 
     * @param name The new name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the email address of the person.
     * 
     * @param email The new email address of the person
     */
    public void setEmail(String email) {
        this.email = email;
    }
}