package Multithreading;

/**
 * Name: Stephen Oduor
 * Date: 12/15/2017
 * Question: 29, 30, 31
 * Description: Write a method that stores an integer.Each time the method is called, increment the integer by 1.
 *              Create three threads that call this method 1000 times each, storing the returned result in their
 *              own set. Print out each thread's set.
 *
 *              Synchronize the method that store and increments the integer. Execute threads again
 *
 */


public class MultithreadingEx implements Runnable{

    private int number = 0;

    public static void main(String[] args){

        MultithreadingEx m1 = new MultithreadingEx();
        MultithreadingEx m2 = new MultithreadingEx();
        MultithreadingEx m3 = new MultithreadingEx();

       Thread t1 =  new Thread(m1);
       Thread t2 = new Thread(m2);
       Thread t3 = new Thread(m3);

       t1.start();
       t2.start();
       t3.start();

       for(int i = 0; i < 1000; i++){
           t1.run();
           t2.run();
           t3.run();
       }

        System.out.println("t1 result: " + m1.getInt());
        System.out.println("t2 result: " + m2.getInt());
        System.out.println("t3 result: " + m3.getInt());
    }

    @Override
    public void run() {
        incrementInt();
    }

    public int getInt(){
        return number;
    }


    public synchronized void incrementInt(){
        number++;
    }




}
