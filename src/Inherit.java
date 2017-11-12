/**
 * Created by Biyanta on 08/09/17.
 */
public class Inherit {

    static class Animal {
        public void move() {
            System.out.println("Animals can move");
        }

    }

    static class Dog extends Animal {
        public void move() {
            System.out.println("Dogs can walk and run");
        }
        public void bark() {
            System.out.println("Dogs can bark");
        }
    }



        static public void main(String args[]) {
            Animal a = new Animal();   // Animal reference and object
            Animal b = new Dog();   // Animal reference but Dog object

            /*When a reference and object type is different,
            then the called method is first checked in the reference class.
            The called method HAS to be present in the reference class,
            then it checks the object type class. If the object type class contains
            that method, then its implementation is first called. If its not present
             in the object class then the method in the reference class is called.

            Reference class is base class.*/

            a.move();   // runs the method in Animal class
            b.move();   // runs the method in Dog class


        }

        public static void main () {
            System.out.println("Blahhh");
        }

}
