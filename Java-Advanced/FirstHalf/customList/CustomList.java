package generics.customList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }
    public void add(T element){
        this.elements.add(element);
    }
    public void remove(int index){
        this.elements.remove(index);
    }
    public boolean contains(T element){
        return this.elements.contains(element);
    }
    public void swap(int first,int second){
        T firstIndex = elements.get(first);
        elements.set(first,elements.get(second));
        elements.set(second,firstIndex);
    }
    public long countGreaterThan(T element){
        return elements.stream().filter(e->e.compareTo(element)>0).count();
    }
    public T getMax(){
      T maxEl = this.elements.get(0);
        for (T element : elements) {
            if (element.compareTo(maxEl)>0){
                maxEl=element;
            }
        }
        return maxEl;
    }
    public T getMin(){
        T minEl = this.elements.get(0);
        for (T element : elements) {
            if (element.compareTo(minEl)<0){
                minEl=element;
            }
        }
        return minEl;
    }
    public int size(){
        return elements.size();
    }
    public T get(int i){
        return elements.get(i);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            sb.append(element);
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}


