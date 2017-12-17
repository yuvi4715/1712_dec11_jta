package bonusExercises;

public class LiveLock {

	public static void main(String[] args) {
		/*
		 * Write a program that creates livelock between two threads. 
		 */
		LiveLock l = new LiveLock();
		final Worker worker1 = l.new Worker("Worker 1", true);
        final Worker worker2 = l.new Worker("Worker 2", true);

        final CommonResource s = l.new CommonResource(worker1);

        new Thread(() -> {
            worker1.work(s, worker2);
        }).start();

        new Thread(() -> {
            worker2.work(s, worker1);
        }).start();

	}
	
	public class Worker {
	    private String name;
	    private boolean active;

	    public Worker (String name, boolean active) {
	        this.name = name;
	        this.active = active;
	    }

	    public String getName () {
	        return name;
	    }

	    public boolean isActive () {
	        return active;
	    }
	    
	    public synchronized void work (CommonResource commonResource, Worker otherWorker) {
	        while (active) {
	            // wait for the resource to become available.
	            if (commonResource.getOwner() != this) {
	                try {
	                    wait(10);
	                } catch (InterruptedException e) {
	                   //ignore
	                }
	                continue;
	            }

	            // If other worker is also active let it do it's work first
	            if (otherWorker.isActive()) {
	                System.out.println(getName() +
	                            " : handover the resource to the worker " +
	                                                       otherWorker.getName());
	                commonResource.setOwner(otherWorker);
	                continue;
	            }

	            //now use the commonResource
	            System.out.println(getName() + ": working on the common resource");
	            active = false;
	            commonResource.setOwner(otherWorker);
	        }
	    }
	}
	
	public class CommonResource {
	    private Worker owner;

	    public CommonResource (Worker d) {
	        owner = d;
	    }

	    public Worker getOwner () {
	        return owner;
	    }

	    public synchronized void setOwner (Worker d) {
	        owner = d;
	    }
	}
}