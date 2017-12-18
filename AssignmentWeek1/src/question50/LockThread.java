package question50;

public class LockThread extends Thread{
	
	public Object left;
	public Object right;
	
	LockThread(Object left, Object right, Runnable runnable){
		super(runnable);
		this.left = left;
		this.right = right;
	}
	

}
