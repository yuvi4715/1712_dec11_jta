package OOP;

public class Main {

    public static void main(String[] args){
        Animal one = new Human(45);
        Mammal two = new Human(50);
        Human three = new Human(67);

        //eat, move, walk
        one.eat(34);
        one.move();
        //one.walk();

        two.eat(55);
        two.move();
        two.walk(true, true, 76);


        three.eat(55);
        three.move();
        three.walk(false, true, 76);
    }

}
