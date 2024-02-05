package form.javafxcrud.model;


public class Student {

    public int id;
    
    public String firstName;
    
    public String middleName;
    
    public String surname;

    public Student(String firtName, String middleName, String surname) {
        this.firstName = firtName;
        this.middleName = middleName;
        this.surname = surname;
    }

    public Student(int id, String firtName, String middleName, String surname) {
        this.id = id;
        this.firstName = firtName;
        this.middleName = middleName;
        this.surname = surname;
    }
    
    

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
}
