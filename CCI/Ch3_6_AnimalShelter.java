package CCI;

import java.util.LinkedList;

/**
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out"
 * basis. People must adopt either the "oldest" of ALL animals at the shelter, or they can select whether they would
 * prefer a dog or a cat (and will recieve the oldest animal of that type). They cannot select which specific animal
 * they would like. Create the data structures to maintain this system and implement operations such as
 * enqueue, deququAny, dequeueDog, and dequeueCat. You may use the built-in LinkedList data structure
 *
 * TODO figure out a way to write tests to prove this class works
 */

public class Ch3_6_AnimalShelter {

    /* an abstract class is a class that can't be instantiated and is used to state or define general characteristics
    *  subclasses extended from an abstract class have all the abstract class's attributes in addition to attributes
    *  specific to each subclass */
    abstract class Animal {
        private int order;
        protected String name;
        public Animal (String n) {
            name = n;
        }
        public void setOrder(int ord) {


        }
        public int getOrder() {
            return order;
        }

        /* Compare orders of animals to return the older item. */
        public boolean isOlderAnimal(Animal a) {
            return this.order < a.getOrder();
        }
    }

    public class Dog extends Animal {
        public Dog(String n) {
            super(n);
        }
    }

    public class Cat extends Animal {
        public Cat(String n) {
            super(n);
        }
    }

    class AnimalQueue {
        LinkedList<Dog> dogs = new LinkedList<Dog>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        private int order = 0; //acts as a timestamp

        public void enqueue(Animal a) {
            a.setOrder(order);
            order++;

            if(a instanceof Dog) dogs.addLast((Dog) a);
            else if(a instanceof Cat) cats.addLast((Cat) a);
        }

        public Animal dequeueAny() {
            //look at tops of dog and cat queues, and pop the queue with oldest value
            if(dogs.size() == 0) {
                return dequeueCats();
            } else if (cats.size() == 0) {
                return dequeueDogs();
            }
            Dog dog = dogs.peek();
            Cat cat = cats.peek();

            if(dog.isOlderAnimal(cat)) {
                return dequeueDogs();
            } else {
                return dequeueCats();
            }
        }

        public Dog dequeueDogs() {
            return dogs.poll();
        }

        public Cat dequeueCats() {
            return cats.poll();
        }
    }
}
