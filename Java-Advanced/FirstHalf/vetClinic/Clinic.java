package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }



    public void add(Pet pet){

        if (this.capacity>this.data.size()){
            this.data.add(pet);
        }
    }
    public boolean remove(String name){

        for (Pet datum : data) {

            if (datum.name.equals(name)) {
                data.remove(datum);
                return true;
            }
        }
        return false;
    }
    public Pet getPet(String name,String owner){
        for (Pet datum : data) {
            if (datum.name.equals(name)&&datum.owner.equals(owner)){
                return datum;
            }
        }
        return null;
    }

    public Pet getOldestPet(){
        int oldest = -1;
        Pet petOldest = new Pet();
        for (Pet datum : data) {
            if (datum.age>oldest){
                oldest=datum.age;
                petOldest=datum;
            }
        }
        return petOldest;
    }
    public int getCount (){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:");
        sb.append(System.lineSeparator());
        for (Pet datum : data) {
            String sf = String.format("%s %s",datum.getName(),datum.getOwner());
            sb.append(sf);
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();


    }
}
//getStatistics() – returns a String in the following format:
//"The clinic has the following patients:
//{name} {owner}
//{name} {owner}
//   (…)"