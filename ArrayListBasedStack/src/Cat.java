/**
 * // -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Sean
 *  @version Oct 8, 2014
 */
public class Cat extends Animal
{
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        //Cat myCat = new Cat();
        Animal myAnimal = new Cat();
        Animal.testClassMethod();
        ((Cat) myAnimal).testInstanceMethod();
    }
}
