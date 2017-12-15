package bonus;


public class Deadlock  {
	public static Object r1 = new Object();
	public static Object r2 = new Object();
	private int index;
	public static class Thread1 extends Thread {
		public void run() {
			synchronized (r1) {
				System.out.println("t1: Locking 1");
				try {
					Thread1.sleep(100);
				}
				catch (InterruptedException e) {
				}
				System.out.println("t1: Locking 2");
				synchronized (r2) {
					System.out.println("t1: Locking 1 & 2");
				}
			}
		}
	}
		
	public static class Thread2 extends Thread {
		public void run() {
			synchronized (r2) {
				System.out.println("t2: Locking 2");
				try {
					Thread1.sleep(100);
				}
				catch (InterruptedException e) {
				}
				System.out.println("t2: Locking 1");
				synchronized (r2) {
					System.out.println("t2: Locking 2 & 1");
				}
			
			
			}
		}
	}
	
	
/*	private final String tname;
    private final Object resource = new Object();
    
    public Deadlock(String tname) {
    	this.tname = tname;
    }
    
    public synchronized void request(Deadlock t) {
    	System.out.println("Requested resource: " + t.getResource() + " on thread: " + t.getTName());
    	t.lock(this);
    }
    
    public synchronized void lock(Deadlock t) {
    	System.out.println("Locked resource: " + t.getResource() + " on thread: " + t.getTName());
    }
    
    public Object getResource() {
        return this.resource;
    }
    public String getTName() {
    	return this.tname;
    }*/
    
	
	
	
	
	
}
