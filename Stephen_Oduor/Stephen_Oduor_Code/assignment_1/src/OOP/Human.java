package OOP;

/**
 * Name: Stephen Oduor
 * Date: 12/12/2017
 * Description: Create a Human class that extends Mammal, overrides eat() and has a static method called
 *              walk().
 */

public class Human extends Mammal {

    int currentPosition;
    boolean left, right;
    //int calories;

    public Human(int currentPosition){
        super(currentPosition);
    }

    public void eat(int c){
        calories = calories + (c - 10);//Calories lost through body processes
    }

    //Assuming human walks in a 2d plane i.e left to right and vice versa
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
