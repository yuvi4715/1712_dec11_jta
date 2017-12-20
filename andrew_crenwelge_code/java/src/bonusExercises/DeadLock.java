package bonusExercises;

public class DeadLock {
	String str1 = "Hello";
    String str2 = "World";
    
	public static void main(String[] args) {
		/*
		 * Write a program that creates deadlock between two threads.
		 */
	    DeadLock dl = new DeadLock();
        dl.trd1.start();
        dl.trd2.start();
	}
	
	Thread trd1 = new Thread("My Thread 1"){
        public void run(){
        	System.out.println("Starting thread 1");
            while(true){
                synchronized(str1){
                    synchronized(str2){
                        System.out.println(str1 + str2);
                    }
                }
            }
        }
    };
     
    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
        	System.out.println("Starting thread 2");
            while(true){
                synchronized(str2){
                    synchronized(str1){
                        System.out.println(str2 + str1);
                    }
                }
            }
        }
    };
}
