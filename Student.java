import java.util.ArrayList;

public class Student{
    public ArrayList<String> names = new ArrayList<>();
    ArrayList<String> emails = new ArrayList<>();

    public Student() {
        names = new ArrayList<>();
        emails = new ArrayList<>();
    }

    public void addName(String element) {
        names.add(element);
    }

    public void addEmail(String element) {
        emails.add(element);
    }

    public int getEmailSize() {
        return emails.size();
    }

    public int getNameSize() {
        return names.size();
    }
}
