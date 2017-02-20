package Chapter3;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bresai on 2017/2/16.
 */
public class AnimalShelter {
    private List<Animal> list = new LinkedList<>();

    public void enqueue(Animal animal){
        list.add(animal);
    }

    public Animal dequeueAny(){
        return list.remove(list.size() - 1);
    }

    public Dog dequeueDog(){
        for (int i = list.size() - 1; i > 0; i--){
            if (list.get(i) instanceof Dog) {
                Dog dog = (Dog) list.get(i);
                list.remove(i);
                return dog;
            }
        }
        return null;
    }

    public Cat dequeueCat(){
        for (int i = list.size() - 1; i > 0; i--){
            if (list.get(i) instanceof Cat) {
                Cat cat = (Cat) list.get(i);
                list.remove(i);
                return cat;
            }
        }
        return null;
    }

    public static void main(String[] args){
        AnimalShelter object = new AnimalShelter();
        object.enqueue(new Dog(1));
        object.enqueue(new Dog(2));
        object.enqueue(new Cat(3));
        object.enqueue(new Cat(4));
        object.enqueue(new Dog(5));
        object.enqueue(new Cat(6));

        System.out.println(object.dequeueAny().number);
        System.out.println(object.dequeueCat().number);
        System.out.println(object.dequeueDog().number);
        System.out.println(object.dequeueDog().number);
    }
}

class Animal {
    int number;

    public Animal(int number) {
        this.number = number;
    }
}

class Dog extends Animal{

    public Dog(int number) {
        super(number);
    }
}

class Cat extends Animal{

    public Cat(int number) {
        super(number);
    }
}
