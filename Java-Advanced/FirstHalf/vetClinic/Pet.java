package vetClinic;

public class Pet {
    String name;
    int age;
    String owner;

    public Pet(String name, int age, String owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public Pet() {
    }

    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getOwner(){
        return owner;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setOwner(String owner){
        this.owner=owner;
    }
    public String toString(){
        return String.format("%s %d (%s)",name,age,owner);
    }
}
