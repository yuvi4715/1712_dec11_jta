package OOP;

/**
 * Name: Stephen Oduor
 * Date: 12/12/2017
 * Question: Write a class called Mammal that implements Animal and the eat() but doesn't implement move
 * Description: A mammal eats food which contains calories and therefore added to the Mammal
 */

public class Mammal implements Animal {

    int calories ;
    int currentPosition;

    public Mammal(int currentPosition){
        this.currentPosition = currentPosition;
        this.calories = 500;
    }

    @Override
    public void eat(int c) {
        this.calories += c;
    }

    @Override
    public void move() {

    }

    public void walk(boolean left, boolean right, int paces){

        if(!left && !right){
            currentPosition = currentPosition;
        }else if(left && right){
            currentPosition = currentPosition;
        }

        if(left){
            currentPosition -= paces;
        }else if(right){
            currentPosition += paces;
        }
    }

    public int getCurrentPosition(){
        return currentPosition;
    }

    public int getCalories(){
        return calories;
    }













}
