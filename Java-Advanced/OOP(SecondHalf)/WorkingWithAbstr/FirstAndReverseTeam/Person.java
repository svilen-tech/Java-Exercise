package Encapsulation.FirstAndReverseTeam;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void increaseSalary(double bonus) {
        double ourBOnus = bonus * getSalary() / 100;
        if (getAge()<30){
            ourBOnus=ourBOnus/2;
        }
        this.salary = getSalary() + ourBOnus;
    }

    public void setSalary(double salary) {
        if (salary<460){
            throw new IllegalStateException("Salary cannot be less than 460 leva");
        }
        this.salary=salary;
    }
    public void setAge(int age){
        if (age<=0){
            throw new IllegalStateException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }
    public void setFirstName(String firstName){
        if (firstName.length()<3){
            throw new IllegalStateException("First name cannot be less than 3 symbols");
        }
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        if (lastName.length()<3){
            throw new IllegalStateException("Last name cannot be less than 3 symbols");
        }
        this.lastName=lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva.", getFirstName(), getLastName(), getSalary());
    }
}
