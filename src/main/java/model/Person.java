package model;
public class Person{
    private String firstName;
    private String lastName;
    private String birthDate;
    private String sex;
    private String color;

    public Person() {
    }
    public Person(String firstName, String lastName, String birthDate, String sex, String color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.color = color;
        this.birthDate = birthDate;
        this.sex = sex;
    }
    public void setColor(String color) {
        this.color = color.trim();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate.trim().replaceAll("  ","");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex.trim();
    }

    @Override
    public String toString() {

        return lastName + " " + firstName+ " " + sex + " " + birthDate + " " + color;
    }


}


